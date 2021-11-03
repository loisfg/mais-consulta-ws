package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoExame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class PostAgendamentoExameImpl implements PostAgendamentoExame {
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

        // Concatenando data do agendamento
        LocalDateTime dataAgendada = exame.getAgendamento().getDtAtendimento()
                .atTime(exame.getAgendamento().getHrAtendimento());

        // Se a data do agendamento for menor que o dia atual não marcar agendamento
        if (exame.getAgendamento().getDhInsert().isBefore(dataAgendada)) {

            // Validando se há paciente/medico disponiveis
            if (pacienteRepository.existsById(agendamentoExameRequestDTO.getIdPaciente()) &&
                    medicoRepository.existsById(agendamentoExameRequestDTO.getIdMedico())
            ) {
                Agendamento agendamento = exame.getAgendamento();
                agendamento.setPaciente(
                        pacienteRepository.findById(agendamentoExameRequestDTO.getIdPaciente()).get()
                );
                agendamento.setMedico(
                        medicoRepository.findById(agendamentoExameRequestDTO.getIdMedico()).get()
                );
                agendamento.setUbs(
                        ubsRepository.findById(agendamentoExameRequestDTO.getIdUbs()).get()
                );

                exameRepository.save(exame);

                return Optional.of(exame);
            }
        }

        return Optional.empty();
    }
}
