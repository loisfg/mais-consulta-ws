package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;

import java.util.Optional;

public interface GetPatientInfoMobile {
    Optional<PersonalDataDTO> execute(Integer patientId);
}
