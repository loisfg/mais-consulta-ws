package com.bandtec.mais.consulta.usecase.search.impl;

import com.bandtec.mais.consulta.domain.Specialty;
import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.gateway.repository.EspecialidadeRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.usecase.search.SearchEspecialidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SearchEspecialidadeImpl implements SearchEspecialidade {
    @Autowired
    EspecialidadeRepository especialidadeRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public Set<Doctor> execute(String descricao) {
        Specialty specialty = especialidadeRepository.findByDescricao(descricao);

        return medicoRepository.findAllByEspecialidade(specialty);

        //TODO retirar especialidade do retorno do JSON;
    }
}
