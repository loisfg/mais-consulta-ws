package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.database.repository.*;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Override
    public Optional<Consulta> execute(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO) {
        Consulta consulta = AgendamentoConsultaRequestDTO.convertFromController(agendamentoConsultaRequestDTO);

        if (pacienteRepository.existsById(agendamentoConsultaRequestDTO.getIdPaciente()) &&
                medicoRepository.existsById(agendamentoConsultaRequestDTO.getIdMedico())) {

            Paciente paciente = pacienteRepository.findById(agendamentoConsultaRequestDTO.getIdPaciente()).get();
            Medico medico = medicoRepository.findById(agendamentoConsultaRequestDTO.getIdMedico()).get();
            Ubs ubs = ubsRepository.findById(agendamentoConsultaRequestDTO.getIdUbs()).get();

            Agendamento agendamento = consulta.getAgendamento();
            agendamento.setPaciente(paciente);
            agendamento.setMedico(medico);
            agendamento.setUbs(ubs);
            agendamento.setDataHr(LocalDate.now());
            agendamento.setDtAtendimento(consulta.getAgendamento().getDtAtendimento());


            consultaRepository.save(consulta);
            agendamentoRepository.save(agendamento);


            return Optional.of(consulta);
        }


        return Optional.empty();
    }
}
