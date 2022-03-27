package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Allergy;
import com.bandtec.mais.consulta.gateway.repository.AllergyRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.usecase.info.GetAllergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllergyImpl implements GetAllergy {

    @Autowired
    private AllergyRepository allergyRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Allergy> execute(Integer userId) {
        if(patientRepository.existsById(userId)) {
            return allergyRepository.findByPatientId(userId);
        }

        return List.of();
    }
}
