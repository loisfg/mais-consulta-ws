package com.bandtec.mais.consulta.validation;

import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.error.ResourceNotFoundException;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationImpl implements Validation {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public void verifyMedicoExists(Integer doctorId) {

        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if (doctor.isEmpty()) {
            throw new ResourceNotFoundException("doctor ID:" + doctorId + " NOT FOUND");
        }
    }
}
