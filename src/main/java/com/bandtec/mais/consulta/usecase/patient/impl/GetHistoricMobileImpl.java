package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.models.dto.response.PatientHistoricMobileResponseDTO;
import com.bandtec.mais.consulta.usecase.patient.GetHistoricMobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetHistoricMobileImpl implements GetHistoricMobile {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Optional<List<PatientHistoricMobileResponseDTO>> execute(Integer patientId) {
        return patientRepository.findAllPatientHistoricMobile(patientId);
    }
}
