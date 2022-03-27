package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.gateway.repository.DiseaseRepository;
import com.bandtec.mais.consulta.models.dto.response.InfoResponseDTO;
import com.bandtec.mais.consulta.usecase.info.GetChronicDiseaseToComplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GetChronicDiseaseToCompleteImpl implements GetChronicDiseaseToComplete {

    @Autowired
    DiseaseRepository diseaseRepository;

    @Override
    public Optional<Set<InfoResponseDTO>> execute(String name) {
        return diseaseRepository.findDiseasesByNameStartingWithIgnoreCaseAndChronic(name);
    }
}
