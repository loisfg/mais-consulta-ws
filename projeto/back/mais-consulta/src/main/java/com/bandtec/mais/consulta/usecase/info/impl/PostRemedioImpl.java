package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.gateway.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.info.PostRemedio;
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
