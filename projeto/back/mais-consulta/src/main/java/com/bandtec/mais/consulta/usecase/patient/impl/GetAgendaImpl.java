package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.models.dto.response.PacienteAgendamentosResponseDTO;
import com.bandtec.mais.consulta.usecase.patient.GetAgenda;
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
    public Optional<List<PacienteAgendamentosResponseDTO>> execute(Integer idPaciente, LocalDate dtStart, LocalDate dtEnd) {
        return pacienteRepository.findAgendamentosToPaciente(idPaciente, dtStart, dtEnd);
    }
}
