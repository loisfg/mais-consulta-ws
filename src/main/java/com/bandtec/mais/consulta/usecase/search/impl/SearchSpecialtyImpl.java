package com.bandtec.mais.consulta.usecase.search.impl;

import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.usecase.search.SearchSpecialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchSpecialtyImpl implements SearchSpecialty {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<Doctor> execute(String specialty, String district) {
        return doctorRepository.findAllBySpecialty(specialty, district);
    }
}
