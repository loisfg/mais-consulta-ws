package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoConsulta;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.enums.AgendamentoStatusEnum;
import com.bandtec.mais.consulta.usecase.notification.CreateNotification;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoConsulta;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import java.time.DayOfWeek;
import java.time.temporal.TemporalQuery;
import java.util.*;

@Service
public class PostAgendamentoConsultaImpl implements PostAgendamentoConsulta {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private UbsRepository ubsRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private CreateNotification createNotification;

    @Autowired
    private FilaAgendamentoConsulta filaAgendamentoConsulta;

    @Override
    public Optional<Consulta> execute(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO) {
        Consulta consulta = AgendamentoConsultaRequestDTO.convertFromController(agendamentoConsultaRequestDTO);

        if (fds.queryFrom(consulta.getAgendamento().getDtAtendimento())) {
            return Optional.empty();
        }

        if (pacienteRepository.existsById(agendamentoConsultaRequestDTO.getIdPaciente())) {

            try {
                Optional<Agendamento> oAgendamento = agendamentoRepository.findByDtAtendimentoAndHrAtendimento(agendamentoConsultaRequestDTO.getDtAtendimento(), agendamentoConsultaRequestDTO.getHrAtendimento());
                if (oAgendamento.isPresent()) {

                    Agendamento agendamento = oAgendamento.get();

                    if (agendamento.getStatus().equals(AgendamentoStatusEnum.CANCELADO.getDescription())) {
                        efetuarAgendamentoConsulta(agendamentoConsultaRequestDTO, consulta);
                    } else {
                        agendamentoConsultaRequestDTO.setStatus(AgendamentoStatusEnum.AGUARDE.getDescription());
                        filaAgendamentoConsulta.setFilaAgendamentoConsulta(agendamentoConsultaRequestDTO);
                        return Optional.of(consulta);
                    }
                }

            } catch (NonUniqueResultException nonUniqueResultException) {
                System.out.println("Tratar esse erro");
            }

            efetuarAgendamentoConsulta(agendamentoConsultaRequestDTO, consulta);

        }
        return Optional.of(consulta);
    }

    private void efetuarAgendamentoConsulta(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO, Consulta consulta) {
        List<Medico> medicoList = medicosLivres(agendamentoConsultaRequestDTO);
        Agendamento agendamento = consulta.getAgendamento();
        if (medicoList.isEmpty()) {
            return;
        }
        Medico medico = medicoList.stream().findFirst().orElseThrow();
        agendamento.setMedico(medico);
        agendamento.setPaciente(pacienteRepository.findById(agendamentoConsultaRequestDTO.getIdPaciente()).get());
        agendamento.setEspecialidade(medico.getEspecialidade());
        agendamento.setStatus(AgendamentoStatusEnum.ATIVO.getDescription());

        consultaRepository.save(consulta);
        agendamentoRepository.save(agendamento);

        createNotification.execute(agendamento, "consulta");
    }

    @SneakyThrows
    private List<Medico> medicosLivres(AgendamentoConsultaRequestDTO reqDTO) {
        List<Medico> medicosInUbs = medicoRepository.findMedicosByUbsId(reqDTO.getIdUbs());
        List<Medico> medicosOcupados = medicoRepository.findMedicosByAgendamento(
                reqDTO.getDtAtendimento(),
                reqDTO.getHrAtendimento(),
                AgendamentoStatusEnum.CANCELADO.getDescription()
        );
        List<Medico> medicosLivres = new ArrayList<>();

        if (medicosOcupados.isEmpty()) {
            medicosLivres.addAll(medicosInUbs);
        }

        medicosInUbs.forEach((medico) -> {
            medicosOcupados.forEach(ocuped -> {
                if (ocuped.equals(medico)) {
                    medicosLivres.remove(medico);
                }
            });
        });

        return medicosLivres;
    }

    TemporalQuery<Boolean> fds = t -> {
        DayOfWeek dow = DayOfWeek.from(t);
        return dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY;
    };
}