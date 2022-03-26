package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Allergy;
import com.bandtec.mais.consulta.gateway.repository.AlergiaRepository;
import com.bandtec.mais.consulta.usecase.info.PutAlergia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutAlergiaImpl implements PutAlergia {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Override
    public Optional<Allergy> execute(Integer id, Allergy allergy) {
        if (alergiaRepository.existsById(id)) {
            allergy.setAllergyId(id);
            return Optional.of(alergiaRepository.save(allergy));
        }
        return Optional.empty();
    }
}
