package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoExame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PostAgendamentoExameImpl implements PostAgendamentoExame {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private UbsRepository ubsRepository;

    @Autowired
    private ExameRepository exameRepository;

    @Override
    public Optional<Exame> execute(AgendamentoExameRequestDTO agendamentoExameRequestDTO) {
        Exame exame = AgendamentoExameRequestDTO.convertFromController(agendamentoExameRequestDTO);
        log.info("CONVERTING DTO to EXAME {} {}", agendamentoExameRequestDTO, exame);

        if (pacienteRepository.existsById(agendamentoExameRequestDTO.getIdPaciente()) &&
                medicoRepository.existsById(agendamentoExameRequestDTO.getIdMedico())) {

            Paciente paciente = pacienteRepository.findById(agendamentoExameRequestDTO.getIdPaciente()).get();
            Medico medico = medicoRepository.findById(agendamentoExameRequestDTO.getIdMedico()).get();
            Ubs ubs = ubsRepository.findById(agendamentoExameRequestDTO.getIdUbs()).get();

            Agendamento agendamento = exame.getAgendamento();
            agendamento.setPaciente(paciente);
            agendamento.setMedico(medico);
            agendamento.setUbs(ubs);

            exameRepository.save(exame);
            agendamentoRepository.save(agendamento);

            log.info("NEW EXAME CREATED {}", exame);
            return Optional.of(exame);
        }


        log.error("ERROR FIND MEDICO or PACIENTE {}", log.isErrorEnabled());
        return Optional.empty();
    }
}
