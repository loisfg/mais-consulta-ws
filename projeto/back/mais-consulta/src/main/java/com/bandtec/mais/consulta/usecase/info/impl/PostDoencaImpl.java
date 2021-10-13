package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.gateway.database.repository.DoencaRepository;
import com.bandtec.mais.consulta.usecase.info.PostDoenca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDoencaImpl implements PostDoenca {

    @Autowired
    private DoencaRepository doencaRepository;

    @Override
    public Doenca execute(Doenca doenca) {
        return doencaRepository.save(doenca);
    }
}
