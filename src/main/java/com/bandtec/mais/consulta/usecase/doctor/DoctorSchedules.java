package com.bandtec.mais.consulta.usecase.doctor;

import com.bandtec.mais.consulta.models.dto.response.DoctorSchedulingDTO;

import java.util.List;
import java.util.Optional;

public interface DoctorSchedules {
    Optional<List<DoctorSchedulingDTO>> execute(Integer patientId);
}
