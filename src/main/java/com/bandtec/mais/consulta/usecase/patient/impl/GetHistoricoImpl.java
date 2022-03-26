package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.models.dto.response.PatientHistoricResponseDTO;
import com.bandtec.mais.consulta.usecase.patient.GetHistorico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetHistoricoImpl implements GetHistorico {

    @Autowired
    PacienteRepository pacienteRepository;

    @Override
    public Optional<List<PatientHistoricResponseDTO>> execute(Integer idPaciente) {
        return pacienteRepository.findAllHistoricoPaciente(idPaciente);
    }
}
