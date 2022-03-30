package com.bandtec.mais.consulta.usecase.doctor;

import com.bandtec.mais.consulta.models.dto.response.DoctorHistoricResponseDTO;

import java.util.List;
import java.util.Optional;

public interface DoctorHistoric {
    Optional<List<DoctorHistoricResponseDTO>> execute(Integer patientId);

    void verify(Integer patientId);
}
