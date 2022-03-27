package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Deficiency;
import com.bandtec.mais.consulta.gateway.repository.DeficiencyRepository;
import com.bandtec.mais.consulta.usecase.info.GetDeficiencyToComplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GetDeficiencyToCompleteImpl implements GetDeficiencyToComplete {

    @Autowired
    DeficiencyRepository deficiencyRepository;

    @Override
    public Optional<Set<Deficiency>> execute(String name) {
        return deficiencyRepository.findByNameStartingWithIgnoreCase(name);
    }
}
