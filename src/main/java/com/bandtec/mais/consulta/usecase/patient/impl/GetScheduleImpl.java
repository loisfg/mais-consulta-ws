package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.models.dto.response.PatientSchedulingResponseDTO;
import com.bandtec.mais.consulta.usecase.patient.GetSchedule;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GetScheduleImpl implements GetSchedule {

    @Autowired
    PatientRepository patientRepository;

    @Override
    @SneakyThrows
    public Optional<List<PatientSchedulingResponseDTO>> execute(Integer patientId,
                                                                String startDate,
                                                                String endDate) {
        return patientRepository
                .findSchedulesToPatient(patientId,
                        LocalDate.parse(startDate),
                        LocalDate.parse(endDate));
    }
}
