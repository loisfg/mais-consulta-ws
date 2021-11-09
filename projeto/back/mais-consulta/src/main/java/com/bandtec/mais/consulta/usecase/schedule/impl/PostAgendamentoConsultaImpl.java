package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
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

    @Override
    public Optional<Consulta> execute(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO) {
        Consulta consulta = AgendamentoConsultaRequestDTO.convertFromController(agendamentoConsultaRequestDTO);

        if (pacienteRepository.existsById(agendamentoConsultaRequestDTO.getIdPaciente()) &&
                medicoRepository.existsById(agendamentoConsultaRequestDTO.getIdMedico())) {

            Agendamento agendamento = consulta.getAgendamento();
            agendamento.setPaciente(pacienteRepository.getById(agendamentoConsultaRequestDTO.getIdPaciente()));
            agendamento.setMedico(medicoRepository.getById(agendamentoConsultaRequestDTO.getIdMedico()));
            agendamento.setEspecialidade(especialidadeRepository.getById(agendamentoConsultaRequestDTO.getIdEspecialidade()));
            agendamento.setUbs(ubsRepository.getById(agendamentoConsultaRequestDTO.getIdUbs()));

            consultaRepository.save(consulta);
            agendamentoRepository.save(agendamento);

            return Optional.of(consulta);
        }

        return Optional.empty();
    }
}
