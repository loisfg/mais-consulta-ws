package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoPutRequestDTO;
import com.bandtec.mais.consulta.usecase.patient.PutPatientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PutPatientInfoImpl implements PutPatientInfo {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientHasMedicinesRepository medicineRepository;

    @Autowired
    private PatientHasDiseasesRepository diseaseRepository;

    @Autowired
    private PatientHasDeficiencyRepository deficiencyRepository;

    @Autowired
    private PatientHasAllergyRepository allergyRepository;

    @Autowired
    private PatientHasActivityRepository activityRepository;

    @Override
    public Optional<Patient> execute(Integer patientId, PatientInfoPutRequestDTO patientInfoResponseDTO) {
        if (patientRepository.existsById(patientId)) {

            Set<PatientHasAllergy> allergySet = allergyRepository.findMedicineByPatientId(patientId);
            Set<PatientHasMedicine> medicineSet = medicineRepository.findMedicineByPatientId(patientId);
            Set<PatientHasDisease> diseaseSet = diseaseRepository.findMedicineByPatientId(patientId);
            Set<PatientHasDeficiency> deficiencySet = deficiencyRepository.findMedicineByPatientId(patientId);
            Set<PatientHasActivity> activitySet = activityRepository.findMedicineByPatientId(patientId);

            // Allergies
            if (patientInfoResponseDTO.getMedicalChart().getAllergies() != null) {
                for (Integer ids : patientInfoResponseDTO.getMedicalChart().getAllergies()) {
                    PatientHasAllergyKey fk = PatientHasAllergyKey
                            .builder()
                            .allergyId(ids)
                            .patientId(patientId)
                            .build();

                    PatientHasAllergy patientHasAllergy = PatientHasAllergy
                            .builder()
                            .patientHasAllergyId(fk)
                            .build();

                    allergySet.add(patientHasAllergy);
                }
            }
            // Medicines
            if (patientInfoResponseDTO.getMedicalChart().getMedicines() != null) {
                for (Integer ids : patientInfoResponseDTO.getMedicalChart().getMedicines()) {
                    PatientHasMedicinesKey fk = PatientHasMedicinesKey
                            .builder()
                            .medicineId(ids)
                            .patientId(patientId)
                            .build();

                    PatientHasMedicine patientHasAllergy = PatientHasMedicine
                            .builder()
                            .patientHasMedicinesId(fk)
                            .build();

                    medicineSet.add(patientHasAllergy);
                }
            }

            // Disease
            if (patientInfoResponseDTO.getMedicalChart().getDiseases() != null) {
                for (Integer ids : patientInfoResponseDTO.getMedicalChart().getDiseases()) {
                    PatientHasDiseaseKey fk = PatientHasDiseaseKey
                            .builder()
                            .diseaseId(ids)
                            .patientId(patientId)
                            .build();

                    PatientHasDisease patientHasAllergy = PatientHasDisease
                            .builder()
                            .patientHasDiseasesId(fk)
                            .build();

                    diseaseSet.add(patientHasAllergy);
                }
            }

            // Deficiencies
            if (patientInfoResponseDTO.getMedicalChart().getDeficiencies() != null) {
                for (Integer ids : patientInfoResponseDTO.getMedicalChart().getDeficiencies()) {
                    PatientHasDeficiencyKey fk = PatientHasDeficiencyKey
                            .builder()
                            .deficiencyId(ids)
                            .patientId(patientId)
                            .build();

                    PatientHasDeficiency patientHasAllergy = PatientHasDeficiency
                            .builder()
                            .patientHasDeficiencyId(fk)
                            .build();

                    deficiencySet.add(patientHasAllergy);
                }
            }

            // Activities
            if (patientInfoResponseDTO.getMedicalChart().getProhibitedActivities() != null) {
                for (Integer ids : patientInfoResponseDTO.getMedicalChart().getProhibitedActivities()) {
                    PatientHasActivityKey fk = PatientHasActivityKey
                            .builder()
                            .activityId(ids)
                            .patientId(patientId)
                            .build();

                    PatientHasActivity patientHasActivity = PatientHasActivity
                            .builder()
                            .patientHasActivityId(fk)
                            .build();

                    activitySet.add(patientHasActivity);
                }
            }

            Patient patient = Patient
                    .builder()
                    .patientId(patientId)
                    .allergies(allergySet)
                    .activities(activitySet)
                    .deficiencies(deficiencySet)
                    .medicines(medicineSet)
                    .diseases(diseaseSet)
                    .name(patientInfoResponseDTO.personalData.getName())
                    .phone(patientInfoResponseDTO.personalData.getPhone())
                    .weight(patientInfoResponseDTO.medicalChart.getWeight())
                    .height(patientInfoResponseDTO.medicalChart.getHeight())
                    .isVirgin(patientInfoResponseDTO.medicalChart.isVirgin())
                    .isSmoker(patientInfoResponseDTO.medicalChart.isSmoker())
                    .bloodType(patientInfoResponseDTO.medicalChart.getBloodType())
                    .build();

            patientRepository.save(patient);

            return Optional.of(patient);
        }

        return Optional.empty();
    }
}
