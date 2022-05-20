package com.bandtec.mais.consulta.usecase.doctor.impl;

import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.models.dto.response.DoctorSchedulingDTO;
import com.bandtec.mais.consulta.usecase.doctor.DoctorSchedules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorSchedulesImpl implements DoctorSchedules {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Optional<List<DoctorSchedulingDTO>> execute(Integer patientId) {
        LocalDate thais = LocalDate.now().plusDays(1);
        System.out.println(thais);
        return doctorRepository.findAllSchedulesByDoctorId(patientId, thais);
    }
}
