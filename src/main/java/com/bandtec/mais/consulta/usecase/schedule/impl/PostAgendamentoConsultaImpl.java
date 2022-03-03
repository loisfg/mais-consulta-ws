package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoConsulta;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.usecase.notification.CreateNotification;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoConsulta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.temporal.TemporalQuery;
import java.util.*;

@Service
@Slf4j
@Primary
public class PostAgendamentoConsultaImpl implements PostAgendamentoConsulta {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private CreateNotification createNotification;

    @Autowired
    private FilaAgendamentoConsulta filaAgendamentoConsulta;

    @Override
    public Optional<Consulta> execute(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO) {
        Consulta consulta = AgendamentoConsultaRequestDTO.convertFromController(agendamentoConsultaRequestDTO);

        if (fds.queryFrom(consulta.getAgendamento().getDtAtendimento())) {
            log.info("Não realizamos agendamentos aos fins de semana {}", consulta.getAgendamento().getDtAtendimento());
            return Optional.empty();
        }

        if (pacienteRepository.existsById(agendamentoConsultaRequestDTO.getIdPaciente())) {
            log.info("Efetuando agendamento com status {}", agendamentoConsultaRequestDTO.getStatus());
            switch (agendamentoConsultaRequestDTO.getStatus()) {
                case ATIVO:
                    efetuarAgendamentoConsulta(agendamentoConsultaRequestDTO, consulta);
                    break;

                case AGUARDE:
                    filaAgendamentoConsulta.setFilaAgendamentoConsulta(consulta);
                    break;

                case CANCELADO:
                case FINALIZADO:
                    break;

                default:
                    throw new IllegalStateException("Status não tratado: " + agendamentoConsultaRequestDTO.getStatus());
            }
        } else {
            log.info("Usuário não existe ou não é um paciente");
            return Optional.empty();
            // TODO adicionar Throw de usuário não existente.
        }

        return Optional.of(consulta);
    }

    private void efetuarAgendamentoConsulta(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO, Consulta consulta) {
        // TODO Adicionar Excpetion para médico não encontrado (procurar locais que precisam e adicionar; por logs tb
        Agendamento agendamento = consulta.getAgendamento();
        Medico medico = medicoRepository.findMedicosByIdEspecialidadeAndIdUbs
                (agendamentoConsultaRequestDTO.getIdEspecialidade(), agendamentoConsultaRequestDTO.getIdUbs()).orElseThrow();
        agendamento.setMedico(medico);
        agendamento.setPaciente(pacienteRepository.findById(agendamentoConsultaRequestDTO.getIdPaciente()).get());
        agendamento.setEspecialidade(medico.getEspecialidade());

        consultaRepository.save(consulta);
        agendamentoRepository.save(agendamento);

        createNotification.execute(agendamento, "consulta");
    }

    private final TemporalQuery<Boolean> fds = t -> {
        DayOfWeek dow = DayOfWeek.from(t);
        return dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY;
    };
}