package com.bandtec.mais.consulta.usecase.userinfo.impl;

import com.bandtec.mais.consulta.domain.Deficiencia;
import com.bandtec.mais.consulta.gateway.database.repository.DeficienciaRepository;
import com.bandtec.mais.consulta.usecase.userinfo.GetDeficiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDeficienciaImpl implements GetDeficiencia {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Override
    public List<Deficiencia> execute(Integer idUser) {
        return deficienciaRepository.findAll();
    }
}
