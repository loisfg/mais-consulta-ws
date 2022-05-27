package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoPutRequestDTO;
import com.bandtec.mais.consulta.usecase.patient.PutPatientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PutPatientInfoImpl implements PutPatientInfo {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Optional<Patient> execute(Integer patientId, PatientInfoPutRequestDTO patientInfoResponseDTO) {
        if (patientRepository.existsById(patientId)) {

            Patient patient = Patient
                    .builder()
                    .patientId(patientId)
                    .name(patientInfoResponseDTO.personalData.getName())
                    .phone(patientInfoResponseDTO.personalData.getPhone())
                    .build();

            patientRepository.save(patient);

            return Optional.of(patient);
        }

        return Optional.empty();
    }
}
