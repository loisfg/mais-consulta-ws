package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.PatientHasMedicine;
import com.bandtec.mais.consulta.domain.PatientHasMedicinesKey;
import com.bandtec.mais.consulta.domain.Medicine;
import com.bandtec.mais.consulta.gateway.repository.PacienteHasRemediosRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.gateway.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.info.PostRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostRemedioImpl implements PostRemedio {

    @Autowired
    private RemedioRepository remedioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteHasRemediosRepository pacienteHasRemediosRepository;

    @Override
    public List<Medicine> execute(Iterable<Integer> remedios, Integer idPaciente) {
        Set<PatientHasMedicine> patientHasMedicineSet = new HashSet<>();
        if (pacienteRepository.existsById(idPaciente)) {
            for (Integer remedioId : remedios) {
                PatientHasMedicinesKey fk = PatientHasMedicinesKey
                        .builder()
                        .medicineId(remedioId)
                        .patientId(idPaciente)
                        .build();

                PatientHasMedicine patientHasMedicine = PatientHasMedicine
                        .builder()
                        .patientHasMedicinesId(fk)
                        .build();

                patientHasMedicineSet.add(patientHasMedicine);
            }

            Patient patient = Patient
                    .builder()
                    .patientId(idPaciente)
                    .medicines(patientHasMedicineSet)
                    .build();

            pacienteRepository.save(patient);
            pacienteHasRemediosRepository.saveAll(patientHasMedicineSet);

        }

        return remedioRepository.findRemedioById(remedios);
    }
}
