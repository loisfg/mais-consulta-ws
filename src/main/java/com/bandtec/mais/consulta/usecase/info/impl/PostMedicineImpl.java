package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.PatientHasMedicine;
import com.bandtec.mais.consulta.domain.PatientHasMedicinesKey;
import com.bandtec.mais.consulta.domain.Medicine;
import com.bandtec.mais.consulta.gateway.repository.PatientHasMedicinesRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicineRepository;
import com.bandtec.mais.consulta.usecase.info.PostMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostMedicineImpl implements PostMedicine {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientHasMedicinesRepository patientHasMedicinesRepository;

    @Override
    public List<Medicine> execute(Iterable<Integer> medicines, Integer patientId) {
        Set<PatientHasMedicine> patientHasMedicineSet = new HashSet<>();
        if (patientRepository.existsById(patientId)) {
            for (Integer medicineId : medicines) {
                PatientHasMedicinesKey fk = PatientHasMedicinesKey
                        .builder()
                        .medicineId(medicineId)
                        .patientId(patientId)
                        .build();

                PatientHasMedicine patientHasMedicine = PatientHasMedicine
                        .builder()
                        .patientHasMedicinesId(fk)
                        .build();

                patientHasMedicineSet.add(patientHasMedicine);
            }

            Patient patient = Patient
                    .builder()
                    .patientId(patientId)
                    .medicines(patientHasMedicineSet)
                    .build();

            patientRepository.save(patient);
            patientHasMedicinesRepository.saveAll(patientHasMedicineSet);

        }

        return medicineRepository.findMedicineById(medicines);
    }
}
