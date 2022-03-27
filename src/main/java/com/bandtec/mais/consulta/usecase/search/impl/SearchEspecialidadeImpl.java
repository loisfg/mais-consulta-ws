package com.bandtec.mais.consulta.usecase.search.impl;

import com.bandtec.mais.consulta.domain.Specialty;
import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.gateway.repository.SpecialtyRepository;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.usecase.search.SearchEspecialidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SearchEspecialidadeImpl implements SearchEspecialidade {
    @Autowired
    SpecialtyRepository specialtyRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Set<Doctor> execute(String descricao) {
        Specialty specialty = specialtyRepository.findByDescription(descricao);

        return doctorRepository.findAllBySpecialties(specialty);

        //TODO retirar especialidade do retorno do JSON;
    }
}
