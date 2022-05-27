package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoPutRequestDTO;

import java.util.Optional;

public interface PutPatientInfo {
    Optional<Patient> execute(Integer patientId, PatientInfoPutRequestDTO patientInfoResponseDTO);
}
