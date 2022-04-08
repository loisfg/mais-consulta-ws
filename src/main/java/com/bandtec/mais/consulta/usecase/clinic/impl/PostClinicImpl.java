package com.bandtec.mais.consulta.usecase.clinic.impl;

import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.gateway.repository.ClinicRepository;
import com.bandtec.mais.consulta.models.dto.request.ClinicPostRequestDTO;
import com.bandtec.mais.consulta.usecase.clinic.PostClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostClinicImpl implements PostClinic {

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public Optional<Clinic> execute(ClinicPostRequestDTO clinicPostRequestDTO) {
        if (clinicRepository.existsByName(clinicPostRequestDTO.getName())) {
            return clinicRepository.findClinicByName(clinicPostRequestDTO.getName());
        }

        Clinic clinic = ClinicPostRequestDTO.convertFromController(clinicPostRequestDTO);
        return Optional.of(clinicRepository.save(clinic));
    }
}
