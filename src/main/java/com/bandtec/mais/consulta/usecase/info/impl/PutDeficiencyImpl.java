package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Deficiency;
import com.bandtec.mais.consulta.gateway.repository.DeficiencyRepository;
import com.bandtec.mais.consulta.usecase.info.PutDeficiency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutDeficiencyImpl implements PutDeficiency {

    @Autowired
    private DeficiencyRepository deficiencyRepository;

    @Override
    public Optional<Deficiency> execute(Integer id, Deficiency deficiency) {

        if (deficiencyRepository.existsById(id)) {
            deficiency.setDeficiencyId(id);
            return Optional.of(deficiencyRepository.save(deficiency));
        }

        return Optional.empty();
    }
}
