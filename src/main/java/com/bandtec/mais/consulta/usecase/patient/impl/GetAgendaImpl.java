package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.models.dto.response.PatientSchedulingResponseDTO;
import com.bandtec.mais.consulta.usecase.patient.GetAgenda;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GetAgendaImpl implements GetAgenda {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    @SneakyThrows
    public Optional<List<PatientSchedulingResponseDTO>> execute(Integer idPaciente, String dtStart, String dtEnd) {
        return pacienteRepository.findAgendamentosToPaciente(idPaciente, LocalDate.parse(dtStart), LocalDate.parse(dtEnd));
    }
}
