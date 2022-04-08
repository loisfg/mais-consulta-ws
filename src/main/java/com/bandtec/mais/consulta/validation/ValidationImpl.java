package com.bandtec.mais.consulta.validation;

import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.error.ResourceNotFoundException;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationImpl implements Validation {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void verifyDoctorExists(Integer doctorId) {

        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if (doctor.isEmpty()) {
            throw new ResourceNotFoundException("doctor ID:" + doctorId + " NOT FOUND");
        }
    }

    @Override
    public void verifyPatient(Integer patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isEmpty()) {
            throw new ResourceNotFoundException("ID Patient:" + patientId + " NOT FOUND");
        }
    }
}
