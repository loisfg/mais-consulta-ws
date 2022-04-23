package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.models.dto.response.PatientHistoricMobileResponseDTO;

import java.util.List;
import java.util.Optional;

public interface GetHistoricMobile {
    Optional<List<PatientHistoricMobileResponseDTO>> execute(Integer patientId);
}
