package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.models.dto.response.PatientHistoricResponseDTO;
import com.bandtec.mais.consulta.usecase.patient.GetHistoric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetHistoricImpl implements GetHistoric {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Optional<List<PatientHistoricResponseDTO>> execute(Integer patientId) {
        return patientRepository.findAllPatientHistoric(patientId);
    }
}
