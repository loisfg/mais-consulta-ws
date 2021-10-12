package com.bandtec.mais.consulta.usecase.userinfo.impl;

import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.gateway.database.repository.DeficienciaRepository;
import com.bandtec.mais.consulta.usecase.userinfo.PutDeficiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutDeficienciaImpl implements PutDeficiencia {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Override
    public Optional<Deficiencia> execute(Integer id, Deficiencia deficiencia) {

        if (deficienciaRepository.existsById(id)) {
            deficiencia.setId(id);
            return Optional.of(deficienciaRepository.save(deficiencia));
        }

        return Optional.empty();
    }
}
