package com.bandtec.mais.consulta.usecase.doctor.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.*;
import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import com.bandtec.mais.consulta.models.dto.request.DiagnosisDTO;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.MedicalChartRequestDTO;
import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import com.bandtec.mais.consulta.usecase.doctor.PostFormularioAtendimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PostFormularioAtendimentoImpl implements PostFormularioAtendimento {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Override
    public Optional<?> execute(Integer idMedico, Integer idPaciente, Integer idAgendamento, PatientInfoRequestDTO patientInfoRequestDTO) {

        if (medicoRepository.existsByIdMedico(idMedico) && pacienteRepository.existsByIdPaciente(idPaciente)) {

            PersonalDataDTO personalDataDTO = patientInfoRequestDTO.getPersonalData();
            MedicalChartRequestDTO prontuarioDTO = patientInfoRequestDTO.getMedicalChart();
            DiagnosisDTO diagnosisDTO = patientInfoRequestDTO.getDiagnosis();

            if (pacienteRepository.existsById(idPaciente)) {

                Set<PatientHasAllergy> alergiaSet = new HashSet<>();
                Set<PatientHasMedicine> remedioSet = new HashSet<>();
                Set<PatientHasDisease> doencaSet = new HashSet<>();
                Set<PatientHasDeficiency> deficienciaSet = new HashSet<>();
                Set<PatientHasActivity> atividadeSet = new HashSet<>();

                if (patientInfoRequestDTO.getMedicalChart().getAllergies() != null) {
                    for (Integer ids : patientInfoRequestDTO.getMedicalChart().getAllergies()) {
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
                if (patientInfoRequestDTO.getMedicalChart().getMedicines() != null) {
                    for (Integer ids : patientInfoRequestDTO.getMedicalChart().getMedicines()) {
                        PatientHasMedicinesKey fk = PatientHasMedicinesKey
                                .builder()
                                .medicineId(ids)
                                .patientId(idPaciente)
                                .build();

                        PatientHasMedicine patientHasMedicine = PatientHasMedicine
                                .builder()
                                .patientHasMedicinesId(fk)
                                .build();

                        remedioSet.add(patientHasMedicine);
                    }
                }
                // Doenca
                if (patientInfoRequestDTO.getMedicalChart().getDiseases() != null) {
                    for (Integer ids : patientInfoRequestDTO.getMedicalChart().getDiseases()) {
                        PatientHasDiseaseKey fk = PatientHasDiseaseKey
                                .builder()
                                .diseaseId(ids)
                                .patientId(idPaciente)
                                .build();

                        PatientHasDisease patientHasDisease = PatientHasDisease
                                .builder()
                                .patientHasDiseasesId(fk)
                                .build();

                        doencaSet.add(patientHasDisease);
                    }
                }
                // Deficiencia
                if (patientInfoRequestDTO.getMedicalChart().getDeficiencies() != null) {
                    for (Integer ids : patientInfoRequestDTO.getMedicalChart().getDeficiencies()) {
                        PatientHasDeficiencyKey fk = PatientHasDeficiencyKey
                                .builder()
                                .deficiencyId(ids)
                                .patientId(idPaciente)
                                .build();

                        PatientHasDeficiency patientHasDeficiency = PatientHasDeficiency
                                .builder()
                                .patientHasDeficiencyId(fk)
                                .build();

                        deficienciaSet.add(patientHasDeficiency);
                    }
                }
                // Atividades
                if (patientInfoRequestDTO.getMedicalChart().getProhibitedActivities() != null) {
                    for (Integer ids : patientInfoRequestDTO.getMedicalChart().getProhibitedActivities()) {
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

                Patient patient = pacienteRepository.findById(idPaciente).get();

                patient.setPatientId(idPaciente);
                patient.setAllergies(alergiaSet);
                patient.setActivities(atividadeSet);
                patient.setDeficiencies(deficienciaSet);
                patient.setMedicines(remedioSet);
                patient.setDiseases(doencaSet);
                patient.setName(personalDataDTO.getName());
                patient.setPhone(personalDataDTO.getPhone());
                patient.setWeight(prontuarioDTO.getWeight());
                patient.setHeight(prontuarioDTO.getHeight());
                patient.setIsVirgin(prontuarioDTO.isVirgin());
                patient.setIsSmoker(prontuarioDTO.isSmoker());
                patient.setBloodType(prontuarioDTO.getBloodType());

                Diagnosis diagnosis = Diagnosis
                        .builder()
                        .medicine(diagnosisDTO.getMedicamentos())
                        .orientacoesMedicas(diagnosisDTO.getOrientacoesMedicas())
                        .complaint(diagnosisDTO.getComplaint())
                        .terminology(diagnosisDTO.getTerminology())
                        .agendamento(agendamentoRepository.getById(idAgendamento))
                        .build();

                diagnosticoRepository.save(diagnosis);
                pacienteRepository.save(patient);
                agendamentoRepository.updateAgendamentoStatus(idAgendamento, SchedulingStatusEnum.FINISHED);

                return Optional.of(patient);
            }
        }
        return Optional.empty();
    }
}