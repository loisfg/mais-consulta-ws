package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientInfoResponseDTO;

import java.util.Optional;

public interface GetPatientInfo {
    Optional<PatientInfoResponseDTO> execute(Integer patientId);

    Optional<PersonalDataDTO> run(Integer patientId);
}
