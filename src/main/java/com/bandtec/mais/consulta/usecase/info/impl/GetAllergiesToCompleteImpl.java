package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Allergy;
import com.bandtec.mais.consulta.gateway.repository.AllergyRepository;
import com.bandtec.mais.consulta.usecase.info.GetAllergiesToComplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GetAllergiesToCompleteImpl implements GetAllergiesToComplete {

    @Autowired
    AllergyRepository allergyRepository;

    @Override
    public Optional<Set<Allergy>> execute(String name) {
        return allergyRepository.findByNameStartingWithIgnoreCase(name);
    }
}
