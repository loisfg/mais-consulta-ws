package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Disease;
import com.bandtec.mais.consulta.gateway.repository.DiseaseRepository;
import com.bandtec.mais.consulta.usecase.info.GetDisease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDiseaseImpl implements GetDisease {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public List<Disease> execute(Integer userId) {
        return diseaseRepository.findAll();
    }
}
