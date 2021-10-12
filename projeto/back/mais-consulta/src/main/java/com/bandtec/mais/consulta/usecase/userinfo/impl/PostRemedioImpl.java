package com.bandtec.mais.consulta.usecase.userinfo.impl;

import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.gateway.database.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.userinfo.PostRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostRemedioImpl implements PostRemedio {

    @Autowired
    private RemedioRepository remedioRepository;

    @Override
    public Remedio execute(Remedio remedio) {
        return remedioRepository.save(remedio);
    }
}
