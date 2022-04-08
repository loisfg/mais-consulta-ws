package com.bandtec.mais.consulta.usecase.patient;

import com.bandtec.mais.consulta.domain.Specialty;

import java.util.List;

public interface GetScheduleSpecialties {
    List<Specialty> execute(Integer patientId);
}
