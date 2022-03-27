package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Allergy;
import com.bandtec.mais.consulta.gateway.repository.AllergyRepository;
import com.bandtec.mais.consulta.usecase.info.PutAllergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutAllergyImpl implements PutAllergy {

    @Autowired
    private AllergyRepository allergyRepository;

    @Override
    public Optional<Allergy> execute(Integer id, Allergy allergy) {
        if (allergyRepository.existsById(id)) {
            allergy.setAllergyId(id);
            return Optional.of(allergyRepository.save(allergy));
        }
        return Optional.empty();
    }
}
