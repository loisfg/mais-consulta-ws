package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Remedio;
import com.bandtec.mais.consulta.gateway.database.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.info.PutRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutRemedioImpl implements PutRemedio {

    @Autowired
    private RemedioRepository remedioRepository;

    @Override
    public Optional<Remedio> execute(Integer id, Remedio remedio) {

        if (remedioRepository.existsById(id)) {
            remedio.setId(id);
            return Optional.of(remedioRepository.save(remedio));
        }

        return Optional.empty();
    }
}
