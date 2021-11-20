package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoConsulta;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.factory.NotificationAdapter;
import com.bandtec.mais.consulta.factory.NotificationFactory;
import com.bandtec.mais.consulta.usecase.notification.CreateNotification;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        if (pacienteRepository.existsById(agendamentoConsultaRequestDTO.getIdPaciente())) {

            Optional<Agendamento> oAgendamento = agendamentoRepository.findByHrAtendimento(agendamentoConsultaRequestDTO.getHrAtendimento());

            if (oAgendamento.isPresent()) {
                filaAgendamentoConsulta.setFilaAgendamentoConsulta(agendamentoConsultaRequestDTO);
                return Optional.of(consulta);
            }

            Agendamento agendamento = consulta.getAgendamento();
            agendamento.setPaciente(pacienteRepository.findById(agendamentoConsultaRequestDTO.getIdPaciente()).get());
            agendamento.setUbs(ubsRepository.findById(agendamentoConsultaRequestDTO.getIdUbs()).get());
            agendamento.setEspecialidade(especialidadeRepository.getById(agendamentoConsultaRequestDTO.getIdEspecialidade()));


            consultaRepository.save(consulta);
            agendamentoRepository.save(agendamento);

            createNotification.execute(agendamento, "consulta");

        }
        return Optional.of(consulta);
    }
}
