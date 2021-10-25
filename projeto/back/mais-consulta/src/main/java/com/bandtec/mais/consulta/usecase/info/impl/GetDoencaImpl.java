package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.gateway.repository.DoencaRepository;
import com.bandtec.mais.consulta.usecase.info.GetDoenca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDoencaImpl implements GetDoenca {

    @Autowired
    private DoencaRepository doencaRepository;

    @Override
    public List<Doenca> execute(Integer idUser) {
        return doencaRepository.findAll();
    }
}
