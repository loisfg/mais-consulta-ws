package com.bandtec.mais.consulta.usecase.schedule.impl;

import com.bandtec.mais.consulta.gateway.repository.SpecialtyRepository;
import com.bandtec.mais.consulta.models.dto.response.SpecialtyResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.GetSpecialties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GetSpecialtiesImpl implements GetSpecialties {

    @Autowired
    SpecialtyRepository specialtyRepository;

    @Override
    public Optional<Set<SpecialtyResponseDTO>> execute() {
        return specialtyRepository.findAllSpecialties();
    }
}
