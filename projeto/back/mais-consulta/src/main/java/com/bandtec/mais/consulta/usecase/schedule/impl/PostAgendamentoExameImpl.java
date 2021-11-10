package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Exame;
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
    private PacienteRepository pacienteRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Autowired
    private UbsRepository ubsRepository;

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public Optional<Exame> execute(AgendamentoExameRequestDTO agendamentoExameRequestDTO) {
        Exame exame = AgendamentoExameRequestDTO.convertFromController(agendamentoExameRequestDTO);

        // Validando se há paciente/medico disponiveis
        if (pacienteRepository.existsById(agendamentoExameRequestDTO.getIdPaciente())) {
            Agendamento agendamento = exame.getAgendamento();
            agendamento.setPaciente(
                    pacienteRepository.getById(agendamentoExameRequestDTO.getIdPaciente())
            );
            // precisamos buscar apenas UBS perto do cidadão, sugiro criar uma tabela nova apenas com as localizações
            // próximas ao usuário
            agendamento.setUbs(
                    ubsRepository.getById(agendamentoExameRequestDTO.getIdUbs())
            );
            agendamento.setEspecialidade(
                    especialidadeRepository.getById(agendamentoExameRequestDTO.getIdEspecialidade())
            );

            agendamentoRepository.save(agendamento);
            exameRepository.save(exame);

        }

        return Optional.of(exame);
    }
}
