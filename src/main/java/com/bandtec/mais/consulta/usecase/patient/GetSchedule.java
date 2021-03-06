package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.models.dto.response.PatientSchedulingResponseDTO;

import java.util.List;
import java.util.Optional;

public interface GetSchedule {
    Optional<List<PatientSchedulingResponseDTO>> execute(Integer patientId, String startDate, String endDate);
}
