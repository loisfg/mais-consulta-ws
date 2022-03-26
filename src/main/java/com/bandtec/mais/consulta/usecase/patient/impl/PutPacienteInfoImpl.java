package com.bandtec.mais.consulta.usecase.patient.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoPutRequestDTO;
import com.bandtec.mais.consulta.usecase.patient.PutPacienteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PutPacienteInfoImpl implements PutPacienteInfo {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteHasRemediosRepository remedioRepository;

    @Autowired
    private PacienteHasDoencasRepository doencaRepository;

    @Autowired
    private PacienteHasDeficienciaRepository deficienciaRepository;

    @Autowired
    private PacienteHasAlergiaRepository alergiaRepository;

    @Autowired
    private PacienteHasAtividadeRepository atividadeRepository;

    @Override
    public Optional<Patient> execute(Integer idPaciente, PatientInfoPutRequestDTO pacienteInfoResponseDTO) {
        if (pacienteRepository.existsById(idPaciente)) {

            Set<PatientHasAllergy> alergiaSet = alergiaRepository.findRemedioByIdPaciente(idPaciente);
            Set<PatientHasMedicine> remedioSet = remedioRepository.findRemedioByIdPaciente(idPaciente);
            Set<PatientHasDisease> doencaSet = doencaRepository.findRemedioByIdPaciente(idPaciente);
            Set<PatientHasDeficiency> deficienciaSet = deficienciaRepository.findRemedioByIdPaciente(idPaciente);
            Set<PatientHasActivity> atividadeSet = atividadeRepository.findRemedioByIdPaciente(idPaciente);

            // Alergias
            if(pacienteInfoResponseDTO.getMedicalChart().getAllergies() != null) {
                for (Integer ids : pacienteInfoResponseDTO.getMedicalChart().getAllergies()) {
                    PatientHasAllergyKey fk = PatientHasAllergyKey
                            .builder()
                            .allergyId(ids)
                            .patientId(idPaciente)
                            .build();

                    PatientHasAllergy patientHasAllergy = PatientHasAllergy
                            .builder()
                            .patientHasAllergyId(fk)
                            .build();

                    alergiaSet.add(patientHasAllergy);
                }
            }
            // Remedio
            if (pacienteInfoResponseDTO.getMedicalChart().getMedicines() != null) {
                for (Integer ids : pacienteInfoResponseDTO.getMedicalChart().getMedicines()) {
                    PatientHasMedicinesKey fk = PatientHasMedicinesKey
                            .builder()
                            .medicineId(ids)
                            .patientId(idPaciente)
                            .build();

                    PatientHasMedicine pacienteHasAlergia = PatientHasMedicine
                            .builder()
                            .patientHasMedicinesId(fk)
                            .build();

                    remedioSet.add(pacienteHasAlergia);
                }
            }
            // Doenca
            if (pacienteInfoResponseDTO.getMedicalChart().getDiseases() != null) {
                for (Integer ids : pacienteInfoResponseDTO.getMedicalChart().getDiseases()) {
                    PatientHasDiseaseKey fk = PatientHasDiseaseKey
                            .builder()
                            .diseaseId(ids)
                            .patientId(idPaciente)
                            .build();

                    PatientHasDisease pacienteHasAlergia = PatientHasDisease
                            .builder()
                            .patientHasDiseasesId(fk)
                            .build();

                    doencaSet.add(pacienteHasAlergia);
                }
            }
            // Deficiencia
            if (pacienteInfoResponseDTO.getMedicalChart().getDeficiencies() != null) {
                for (Integer ids : pacienteInfoResponseDTO.getMedicalChart().getDeficiencies()) {
                    PatientHasDeficiencyKey fk = PatientHasDeficiencyKey
                            .builder()
                            .deficiencyId(ids)
                            .patientId(idPaciente)
                            .build();

                    PatientHasDeficiency pacienteHasAlergia = PatientHasDeficiency
                            .builder()
                            .patientHasDeficiencyId(fk)
                            .build();

                    deficienciaSet.add(pacienteHasAlergia);
                }
            }
            // Atividades
            if(pacienteInfoResponseDTO.getMedicalChart().getProhibitedActivities() != null) {
                for (Integer ids : pacienteInfoResponseDTO.getMedicalChart().getProhibitedActivities()) {
                    PatientHasActivityKey fk = PatientHasActivityKey
                            .builder()
                            .activityId(ids)
                            .patientId(idPaciente)
                            .build();

                    PatientHasActivity patientHasActivity = PatientHasActivity
                            .builder()
                            .patientHasActivityId(fk)
                            .build();

                    atividadeSet.add(patientHasActivity);
                }
            }

            Patient patient = Patient
                    .builder()
                    .patientId(idPaciente)
                    .allergies(alergiaSet)
                    .activities(atividadeSet)
                    .deficiencies(deficienciaSet)
                    .medicines(remedioSet)
                    .diseases(doencaSet)
                    .name(pacienteInfoResponseDTO.personalData.getName())
                    .phone(pacienteInfoResponseDTO.personalData.getPhone())
                    .weight(pacienteInfoResponseDTO.medicalChart.getWeight())
                    .height(pacienteInfoResponseDTO.medicalChart.getHeight())
                    .isVirgin(pacienteInfoResponseDTO.medicalChart.isVirgin())
                    .isSmoker(pacienteInfoResponseDTO.medicalChart.isSmoker())
                    .bloodType(pacienteInfoResponseDTO.medicalChart.getBloodType())
                    .build();

            pacienteRepository.save(patient);

            return Optional.of(patient);
        }

        return Optional.empty();
    }
}
