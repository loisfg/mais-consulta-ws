package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Medicine;
import com.bandtec.mais.consulta.gateway.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.info.GetRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetRemedioImpl implements GetRemedio {

    @Autowired
    private RemedioRepository remedioRepository;

    @Override
    public List<Medicine> execute(Integer idUser) {
        return remedioRepository.findAll();
    }
}
