package com.bandtec.mais.consulta.usecase.search.impl;

import com.bandtec.mais.consulta.domain.Specialty;
import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.gateway.repository.SpecialtyRepository;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.usecase.search.SearchSpecialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SearchSpecialtyImpl implements SearchSpecialty {
    @Autowired
    SpecialtyRepository specialtyRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Set<Doctor> execute(String description) {
        Specialty specialty = specialtyRepository.findByDescription(description);

        return doctorRepository.findAllBySpecialty(specialty);
    }
}
