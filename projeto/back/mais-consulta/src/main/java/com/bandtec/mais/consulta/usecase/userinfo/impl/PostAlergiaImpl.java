package com.bandtec.mais.consulta.usecase.userinfo.impl;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.gateway.database.repository.AlergiaRepository;
import com.bandtec.mais.consulta.usecase.userinfo.PostAlergia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostAlergiaImpl implements PostAlergia {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Override
    public Alergia execute(Alergia alergia) {
        return alergiaRepository.save(alergia);
    }
}
