package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Deficiency;
import com.bandtec.mais.consulta.gateway.repository.DeficienciaRepository;
import com.bandtec.mais.consulta.usecase.info.GetDeficienciaToComplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GetDeficienciaToCompletImpl implements GetDeficienciaToComplet {

    @Autowired
    DeficienciaRepository deficienciaRepository;

    @Override
    public Optional<Set<Deficiency>> execute(String nome) {
        return deficienciaRepository.findByNomeStartingWithIgnoreCase(nome);
    }
}
