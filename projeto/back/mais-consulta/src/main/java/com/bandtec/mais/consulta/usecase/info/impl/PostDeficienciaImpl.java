package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.gateway.database.repository.DeficienciaRepository;
import com.bandtec.mais.consulta.usecase.info.PostDeficiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDeficienciaImpl implements PostDeficiencia {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Override
    public Deficiencia execute(Deficiencia deficiencia) {
        return deficienciaRepository.save(deficiencia);
    }
}
