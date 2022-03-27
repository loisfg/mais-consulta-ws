package com.bandtec.mais.consulta.usecase.doctor;

import com.bandtec.mais.consulta.models.dto.request.PatientInfoRequestDTO;

import java.util.Optional;

public interface PostTreatmentForm {
    Optional<?> execute(Integer doctorId,
                        Integer patientId,
                        Integer schedulingId,
                        PatientInfoRequestDTO patientInfoRequestDTO);
}
