package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Doenca;
import com.bandtec.mais.consulta.gateway.repository.DoencaRepository;
import com.bandtec.mais.consulta.usecase.info.PutDoenca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutDoencaImpl implements PutDoenca {

    @Autowired
    private DoencaRepository doencaRepository;

    @Override
    public Optional<Doenca> execute(Integer id, Doenca doenca) {

        if (doencaRepository.existsById(id)){
            doenca.setId(id);
            return Optional.of(doencaRepository.save(doenca));
        }

        return Optional.empty();
    }
}
