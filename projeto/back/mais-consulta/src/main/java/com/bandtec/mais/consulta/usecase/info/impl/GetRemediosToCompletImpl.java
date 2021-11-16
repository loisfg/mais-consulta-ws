package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.gateway.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.info.GetRemediosToComplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GetRemediosToCompletImpl implements GetRemediosToComplet {

    @Autowired
    RemedioRepository remedioRepository;

    @Override
    public Set<Remedio> execute(String nome) {
        return remedioRepository.findByNomeStartingWithIgnoreCase(nome);
    }
}
