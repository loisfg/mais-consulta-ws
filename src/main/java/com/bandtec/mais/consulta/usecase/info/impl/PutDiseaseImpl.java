package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Disease;
import com.bandtec.mais.consulta.gateway.repository.DiseaseRepository;
import com.bandtec.mais.consulta.usecase.info.PutDisease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutDiseaseImpl implements PutDisease {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public Optional<Disease> execute(Integer id, Disease disease) {

        if (diseaseRepository.existsById(id)){
            disease.setDiseaseId(id);
            return Optional.of(diseaseRepository.save(disease));
        }

        return Optional.empty();
    }
}
