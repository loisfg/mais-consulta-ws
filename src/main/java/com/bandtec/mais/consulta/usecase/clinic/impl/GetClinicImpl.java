package com.bandtec.mais.consulta.usecase.clinic.impl;

import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.gateway.repository.ClinicRepository;
import com.bandtec.mais.consulta.usecase.clinic.GetClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetClinicImpl implements GetClinic {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ClinicRepository clinicRepository;

    @Override
    public Optional<List<Clinic>> execute(Integer patientId) {
        return clinicRepository.findClinicByPatientId(patientId);
    }
}
