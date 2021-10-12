package com.bandtec.mais.consulta.usecase.userinfo.impl;

import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.gateway.database.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.userinfo.GetRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetRemedioImpl implements GetRemedio {

    @Autowired
    private RemedioRepository remedioRepository;

    @Override
    public List<Remedio> execute(Integer idUser) {
        return remedioRepository.findAll();
    }
}
