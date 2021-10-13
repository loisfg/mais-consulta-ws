package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.gateway.database.repository.AlergiaRepository;
import com.bandtec.mais.consulta.usecase.info.PutAlergia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutAlergiaImpl implements PutAlergia {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Override
    public Optional<Alergia> execute(Integer id, Alergia alergia) {
        if (alergiaRepository.existsById(id)) {
            alergia.setId(id);
            return Optional.of(alergiaRepository.save(alergia));
        }
        return Optional.empty();
    }
}
