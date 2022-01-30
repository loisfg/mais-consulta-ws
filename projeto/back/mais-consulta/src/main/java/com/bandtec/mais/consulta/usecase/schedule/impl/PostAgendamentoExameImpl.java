package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoExame;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.models.enums.AgendamentoStatusEnum;
import com.bandtec.mais.consulta.usecase.notification.CreateNotification;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoExame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import java.util.Optional;

@Service
@Slf4j
public class PostAgendamentoExameImpl implements PostAgendamentoExame {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private CreateNotification createNotification;

    @Autowired
    private FilaAgendamentoExame filaAgendamentoExame;

    @Override
    public Optional<Exame> execute(AgendamentoExameRequestDTO agendamentoExameRequestDTO) {
        Exame exame = AgendamentoExameRequestDTO.convertFromController(agendamentoExameRequestDTO);

        if (pacienteRepository.existsById(agendamentoExameRequestDTO.getIdPaciente())) {
            try{
                Optional<Agendamento> oAgendamento = agendamentoRepository.findByDtAtendimentoAndHrAtendimento(agendamentoExameRequestDTO.getDtAtendimento(), agendamentoExameRequestDTO.getHrAtendimento());
                if (oAgendamento.isPresent()) {

                    Agendamento agendamento = oAgendamento.get();

                    if (agendamento.getStatus().equals(AgendamentoStatusEnum.CANCELADO.getDescription())) {
                        efetuarAgendamentoExame(agendamentoExameRequestDTO, exame);
                    } else {
                        agendamentoExameRequestDTO.setStatus(AgendamentoStatusEnum.AGUARDE.getDescription());
                        filaAgendamentoExame.setFilaAgendamentoExame(agendamentoExameRequestDTO);
                        return Optional.of(exame);
                    }
                }

            }catch (NonUniqueResultException nonUniqueResultException){
                System.out.println("Tratar esse erro");
            }

            efetuarAgendamentoExame(agendamentoExameRequestDTO, exame);
        }

        return Optional.of(exame);
    }

    private void efetuarAgendamentoExame(AgendamentoExameRequestDTO agendamentoExameRequestDTO, Exame exame) {
        Agendamento agendamento = exame.getAgendamento();
        agendamento.setStatus(AgendamentoStatusEnum.ATIVO.getDescription());
        agendamento.setPaciente(pacienteRepository.findById(agendamentoExameRequestDTO.getIdPaciente()).get());
        agendamento.setEspecialidade(especialidadeRepository.findById(agendamentoExameRequestDTO.getIdEspecialidade()).get());
        agendamento.setMedico(medicoRepository.findMedicosByIdEspecialidadeAndIdUbs(agendamentoExameRequestDTO.getIdEspecialidade(), agendamentoExameRequestDTO.getIdUbs()).get());

        exameRepository.save(exame);
        agendamentoRepository.save(agendamento);
        createNotification.execute(agendamento, "exame");
    }
}
