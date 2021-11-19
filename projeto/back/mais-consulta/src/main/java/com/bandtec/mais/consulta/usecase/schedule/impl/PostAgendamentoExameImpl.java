package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.factory.NotificationAdapter;
import com.bandtec.mais.consulta.factory.NotificationFactory;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoExame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationFactory notificationFactory;

    @Override
    public Optional<Exame> execute(AgendamentoExameRequestDTO agendamentoExameRequestDTO) {
        Exame exame = AgendamentoExameRequestDTO.convertFromController(agendamentoExameRequestDTO);

        if (pacienteRepository.existsById(agendamentoExameRequestDTO.getIdPaciente())) {
            //select medico.Id_medico from medico inner join ubs ON ubs.ID_UBS = medico.UBS_ID
            //JOIN especialidade on especialidade.ID_ESPECIALIDADE = medico.ESPECIALIDADE_ID
            //where UBS.ID_UBS = 1

            Agendamento agendamento = exame.getAgendamento();
            agendamento.setPaciente(pacienteRepository.findById(agendamentoExameRequestDTO.getIdPaciente()).get());
            agendamento.setEspecialidade(especialidadeRepository.findById(agendamentoExameRequestDTO.getIdEspecialidade()).get());
            agendamento.setUbs(ubsRepository.findById(agendamentoExameRequestDTO.getIdUbs()).get());

            exameRepository.save(exame);
            agendamentoRepository.save(agendamento);

            NotificationAdapter notificationMessageService = notificationFactory.getNotificationAdapter("exame");

            String descricaoNotification = notificationMessageService.getNotificationMessage(agendamento);

        }

        return Optional.of(exame);
    }
}
