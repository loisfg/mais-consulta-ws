package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.Specialty;
import com.bandtec.mais.consulta.usecase.patient.GetScheduleSpecialties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetScheduleSpecialtiesImpl implements GetScheduleSpecialties {

    @Override
    public List<Specialty> execute(Integer patientId) {
        return null;
    }
}
