package com.bandtec.mais.consulta.usecase.userinfo.impl;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.gateway.database.repository.AlergiaRepository;
import com.bandtec.mais.consulta.usecase.userinfo.GetAlergia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAlergiaImpl implements GetAlergia {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Override
    public List<Alergia> execute(Integer idUser) {
        return alergiaRepository.findAll();
    }
}
