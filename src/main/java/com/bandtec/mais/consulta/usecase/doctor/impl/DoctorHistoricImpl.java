package com.bandtec.mais.consulta.usecase.doctor.impl;

import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.error.ResourceNotFoundException;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.models.dto.response.DoctorHistoricResponseDTO;
import com.bandtec.mais.consulta.usecase.doctor.DoctorHistoric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorHistoricImpl implements DoctorHistoric {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Optional<List<DoctorHistoricResponseDTO>> execute(Integer patientId) {
        return doctorRepository.findSchedulesHistoric(patientId);
    }

    @Override
    public void verify(Integer patientId) {
        Optional<Doctor> doctor = doctorRepository.findById(patientId);
        if (doctor.isEmpty()) {
            throw new ResourceNotFoundException("ID doctor:" + patientId + " NOT FOUND");
        }
    }
}
