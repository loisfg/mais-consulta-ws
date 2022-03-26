package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Disease;
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
    public Optional<Disease> execute(Integer id, Disease disease) {

        if (doencaRepository.existsById(id)){
            disease.setDiseaseId(id);
            return Optional.of(doencaRepository.save(disease));
        }

        return Optional.empty();
    }
}
