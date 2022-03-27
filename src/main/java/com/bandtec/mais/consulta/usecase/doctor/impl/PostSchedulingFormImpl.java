package com.bandtec.mais.consulta.usecase.doctor.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import com.bandtec.mais.consulta.models.dto.request.DiagnosisDTO;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.MedicalChartRequestDTO;
import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import com.bandtec.mais.consulta.usecase.doctor.PostTreatmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PostSchedulingFormImpl implements PostTreatmentForm {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public Optional<?> execute(Integer doctorId, Integer patientId, Integer schedulingId, PatientInfoRequestDTO patientInfoRequestDTO) {

        if (doctorRepository.existsByDoctorId(doctorId) && patientRepository.existsByPatientId(patientId)) {

            PersonalDataDTO personalDataDTO = patientInfoRequestDTO.getPersonalData();
            MedicalChartRequestDTO medicalChartDTO = patientInfoRequestDTO.getMedicalChart();
            DiagnosisDTO diagnosisDTO = patientInfoRequestDTO.getDiagnosis();

            if (patientRepository.existsById(patientId)) {

                Set<PatientHasAllergy> allergySet = new HashSet<>();
                Set<PatientHasMedicine> medicineSet = new HashSet<>();
                Set<PatientHasDisease> diseaseSet = new HashSet<>();
                Set<PatientHasDeficiency> deficiencySet = new HashSet<>();
                Set<PatientHasActivity> activitySet = new HashSet<>();

                if (patientInfoRequestDTO.getMedicalChart().getAllergies() != null) {
                    for (Integer ids : patientInfoRequestDTO.getMedicalChart().getAllergies()) {
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

                // Medicine
                if (patientInfoRequestDTO.getMedicalChart().getMedicines() != null) {
                    for (Integer ids : patientInfoRequestDTO.getMedicalChart().getMedicines()) {
                        PatientHasMedicinesKey fk = PatientHasMedicinesKey
                                .builder()
                                .medicineId(ids)
                                .patientId(patientId)
                                .build();

                        PatientHasMedicine patientHasMedicine = PatientHasMedicine
                                .builder()
                                .patientHasMedicinesId(fk)
                                .build();

                        medicineSet.add(patientHasMedicine);
                    }
                }

                // Disease
                if (patientInfoRequestDTO.getMedicalChart().getDiseases() != null) {
                    for (Integer ids : patientInfoRequestDTO.getMedicalChart().getDiseases()) {
                        PatientHasDiseaseKey fk = PatientHasDiseaseKey
                                .builder()
                                .diseaseId(ids)
                                .patientId(patientId)
                                .build();

                        PatientHasDisease patientHasDisease = PatientHasDisease
                                .builder()
                                .patientHasDiseasesId(fk)
                                .build();

                        diseaseSet.add(patientHasDisease);
                    }
                }

                // Deficiency
                if (patientInfoRequestDTO.getMedicalChart().getDeficiencies() != null) {
                    for (Integer ids : patientInfoRequestDTO.getMedicalChart().getDeficiencies()) {
                        PatientHasDeficiencyKey fk = PatientHasDeficiencyKey
                                .builder()
                                .deficiencyId(ids)
                                .patientId(patientId)
                                .build();

                        PatientHasDeficiency patientHasDeficiency = PatientHasDeficiency
                                .builder()
                                .patientHasDeficiencyId(fk)
                                .build();

                        deficiencySet.add(patientHasDeficiency);
                    }
                }

                // Activities
                if (patientInfoRequestDTO.getMedicalChart().getProhibitedActivities() != null) {
                    for (Integer ids : patientInfoRequestDTO.getMedicalChart().getProhibitedActivities()) {
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

                Patient patient = patientRepository.findById(patientId).get();

                patient.setPatientId(patientId);
                patient.setAllergies(allergySet);
                patient.setActivities(activitySet);
                patient.setDeficiencies(deficiencySet);
                patient.setMedicines(medicineSet);
                patient.setDiseases(diseaseSet);
                patient.setName(personalDataDTO.getName());
                patient.setPhone(personalDataDTO.getPhone());
                patient.setWeight(medicalChartDTO.getWeight());
                patient.setHeight(medicalChartDTO.getHeight());
                patient.setIsVirgin(medicalChartDTO.isVirgin());
                patient.setIsSmoker(medicalChartDTO.isSmoker());
                patient.setBloodType(medicalChartDTO.getBloodType());

                Diagnosis diagnosis = Diagnosis
                        .builder()
                        .medicine(diagnosisDTO.getMedicines())
                        .medicalGuidelines(diagnosisDTO.getMedicalGuidelines())
                        .complaint(diagnosisDTO.getComplaint())
                        .terminology(diagnosisDTO.getTerminology())
                        .scheduling(schedulingRepository.getById(schedulingId))
                        .build();

                diagnosisRepository.save(diagnosis);
                patientRepository.save(patient);
                schedulingRepository.updateSchedulingStatus(schedulingId, SchedulingStatusEnum.FINISHED);

                return Optional.of(patient);
            }
        }
        return Optional.empty();
    }
}