package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.gateway.repository.AlergiaRepository;
import com.bandtec.mais.consulta.usecase.info.GetAlergiasToComplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GetAlergiasToCompletImpl implements GetAlergiasToComplet {

    @Autowired
    AlergiaRepository alergiaRepository;

    @Override
    public Optional<Set<Alergia>> execute(String nome) {
        return alergiaRepository.findByNomeStartingWithIgnoreCase(nome);
    }
}
