package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoConsulta;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoExame;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.factory.NotificationAdapter;
import com.bandtec.mais.consulta.factory.NotificationFactory;
import com.bandtec.mais.consulta.usecase.notification.CreateNotification;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoExame;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostAgendamentoExameImpl implements PostAgendamentoExame {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private UbsRepository ubsRepository;

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
            //select medico.Id_medico from medico inner join ubs ON ubs.ID_UBS = medico.UBS_ID
            //JOIN especialidade on especialidade.ID_ESPECIALIDADE = medico.ESPECIALIDADE_ID
            //where UBS.ID_UBS = 1

            try{
                Optional<Agendamento> oAgendamento = agendamentoRepository.findByDtAtendimentoAndHrAtendimento(agendamentoExameRequestDTO.getDtAtendimento(), agendamentoExameRequestDTO.getHrAtendimento());
                if (oAgendamento.isPresent()) {

                    Agendamento agendamento = oAgendamento.get();

                    if (agendamento.getStatus().equals("CANCELADO")) {
                        efetuarAgendamentoExame(agendamentoExameRequestDTO, exame);
                    } else {
                        agendamentoExameRequestDTO.setStatus("AGUARDANDO");
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
        agendamento.setStatus("ATIVO");
        agendamento.setPaciente(pacienteRepository.findById(agendamentoExameRequestDTO.getIdPaciente()).get());
        agendamento.setEspecialidade(especialidadeRepository.findById(agendamentoExameRequestDTO.getIdEspecialidade()).get());
        agendamento.setUbs(ubsRepository.findById(agendamentoExameRequestDTO.getIdUbs()).get());

        exameRepository.save(exame);
        agendamentoRepository.save(agendamento);
        createNotification.execute(agendamento, "exame");
    }
}
