package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.DiseaseRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientHasDiseasesRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.usecase.info.PostDisease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostDiseaseImpl implements PostDisease {

    @Autowired
    PatientHasDiseasesRepository patientHasDiseaseRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public List<Disease> execute(Iterable<Integer> diseasesId, Integer patientId) {
        Set<PatientHasDisease> patientHasMedicinesSet = new HashSet<>();
        if (patientRepository.existsById(patientId)) {
            for (Integer allergyId : diseasesId) {
                PatientHasDiseaseKey fk = PatientHasDiseaseKey
                        .builder()
                        .diseaseId(allergyId)
                        .patientId(patientId)
                        .build();

                PatientHasDisease patientHasDisease = PatientHasDisease
                        .builder()
                        .patientHasDiseasesId(fk)
                        .build();

                patientHasMedicinesSet.add(patientHasDisease);
            }

            Patient patient = Patient
                    .builder()
                    .patientId(patientId)
                    .diseases(patientHasMedicinesSet)
                    .build();

            patientRepository.save(patient);
            patientHasDiseaseRepository.saveAll(patientHasMedicinesSet);
        }

        return diseaseRepository.findByPatientId(patientId);
    }
}