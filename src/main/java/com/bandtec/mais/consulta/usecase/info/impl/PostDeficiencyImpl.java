package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Deficiency;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.PatientHasDeficiency;
import com.bandtec.mais.consulta.domain.PatientHasDeficiencyKey;
import com.bandtec.mais.consulta.gateway.repository.DeficiencyRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientHasDeficiencyRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.usecase.info.PostDeficiency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostDeficiencyImpl implements PostDeficiency {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DeficiencyRepository deficiencyRepository;

    @Autowired
    private PatientHasDeficiencyRepository patientHasDeficiencyRepository;

    @Override
    public List<Deficiency> execute(Iterable<Integer> deficiency, Integer patientId) {
        Set<PatientHasDeficiency> patientHasMedicinesSet = new HashSet<>();
        if (patientRepository.existsById(patientId)) {
            for (Integer deficiencyId : deficiency) {
                PatientHasDeficiencyKey fk = PatientHasDeficiencyKey
                        .builder()
                        .deficiencyId(deficiencyId)
                        .patientId(patientId)
                        .build();

                PatientHasDeficiency patientHasDeficiency = PatientHasDeficiency
                        .builder()
                        .patientHasDeficiencyId(fk)
                        .build();

                patientHasMedicinesSet.add(patientHasDeficiency);
            }

            Patient patient = Patient
                    .builder()
                    .patientId(patientId)
                    .deficiencies(patientHasMedicinesSet)
                    .build();

            patientRepository.save(patient);
            patientHasDeficiencyRepository.saveAll(patientHasMedicinesSet);
        }

        return deficiencyRepository.findByPatientId(patientId);
    }
}
