package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Allergy;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.PatientHasAllergy;
import com.bandtec.mais.consulta.domain.PatientHasAllergyKey;
import com.bandtec.mais.consulta.gateway.repository.AllergyRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientHasAllergyRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.usecase.info.PostAllergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostAllergyImpl implements PostAllergy {

    @Autowired
    private AllergyRepository allergyRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    PatientHasAllergyRepository patientHasAllergyRepository;

    @Override
    public List<Allergy> execute(Iterable<Integer> allergies, Integer patientId) {
        Set<PatientHasAllergy> patientHasAllergiesSet = new HashSet<>();
        if (patientRepository.existsById(patientId)) {
            for (Integer allergyId : allergies) {
                PatientHasAllergyKey fk = PatientHasAllergyKey
                        .builder()
                        .allergyId(allergyId)
                        .patientId(patientId)
                        .build();

                PatientHasAllergy patientHasAllergy = PatientHasAllergy
                        .builder()
                        .patientHasAllergyId(fk)
                        .build();

                patientHasAllergiesSet.add(patientHasAllergy);
            }

            Patient patient = Patient
                    .builder()
                    .patientId(patientId)
                    .allergies(patientHasAllergiesSet)
                    .build();

            patientRepository.save(patient);
            patientHasAllergyRepository.saveAll(patientHasAllergiesSet);
        }

        return allergyRepository.findAllById(allergies);
    }
}
