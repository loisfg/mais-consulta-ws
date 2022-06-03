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
            Optional<Patient> patient = patientRepository.findByPatientId(patientId);
            patient.get().setName(patientInfoResponseDTO.getPersonalData().getName());
            patient.get().getAddress().setPublicPlace(patientInfoResponseDTO.getPersonalData().getPublicPlace());
            patient.get().setPhone(patientInfoResponseDTO.getPersonalData().getCellPhone());
            patient.get().getUser().setCpf(patientInfoResponseDTO.getPersonalData().getCpf());
            patient.get().setNumberWallet(patientInfoResponseDTO.getPersonalData().getSusNumber());
            patient.get().getAddress().setCity(patientInfoResponseDTO.getPersonalData().getCity());
            patient.get().getAddress().setState(patientInfoResponseDTO.getPersonalData().getState());
            patient.get().getAddress().setDistrict(patientInfoResponseDTO.getPersonalData().getDistrict());
            patient.get().getAddress().setZipCode(patientInfoResponseDTO.getPersonalData().getCep());

            patientRepository.save(patient.get());

            return patient;
        }

        return Optional.empty();
    }
}
