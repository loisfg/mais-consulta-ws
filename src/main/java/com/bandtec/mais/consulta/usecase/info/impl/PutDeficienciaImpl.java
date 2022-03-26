package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Deficiency;
import com.bandtec.mais.consulta.gateway.repository.DeficienciaRepository;
import com.bandtec.mais.consulta.usecase.info.PutDeficiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutDeficienciaImpl implements PutDeficiencia {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Override
    public Optional<Deficiency> execute(Integer id, Deficiency deficiency) {

        if (deficienciaRepository.existsById(id)) {
            deficiency.setDeficiencyId(id);
            return Optional.of(deficienciaRepository.save(deficiency));
        }

        return Optional.empty();
    }
}
