package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.gateway.repository.SchedulingRepository;
import com.bandtec.mais.consulta.gateway.repository.UserRepository;
import com.bandtec.mais.consulta.usecase.export.ExportConsult;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExportConsultImpl implements ExportConsult {
    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<String> execute(Integer patientId) {

        if (userRepository.existsById(patientId)) {

            List<Scheduling> schedulingList = schedulingRepository.findBySchedulingByPatientId(patientId);

            if (schedulingList.isEmpty()) {
                return Optional.empty();
            }

            String dataSchedulingFile = buildDataSchedulingFile(schedulingList);

            return Optional.of(dataSchedulingFile);
        }

        return Optional.empty();
    }

    public String buildDataSchedulingFile(List<Scheduling> schedulingList) {

        StringBuilder text = new StringBuilder();
        String header = "data do atendimento;especialidade da consulta;nome do paciente;nome do medico;nome da clinica\n";
        text.append(header);
        schedulingList.forEach(scheduling -> {
            String specialty = scheduling.getSpecialty().getDescription();
            LocalDate schedulingData = scheduling.getSchedulingDate();
            Patient patient = scheduling.getPatient();
            String patientName = patient.getName();
            Doctor doctor = scheduling.getDoctor();
            String doctorName = doctor.getName();
            Clinic clinic = doctor.getClinic();
            String clinicName = clinic.getName();
            text.append(buildSchedulingText(specialty, schedulingData, patientName, doctorName, clinicName));
        });

        return text.toString();
    }

    @NotNull
    private String buildSchedulingText(String specialty,
                                       LocalDate schedulingData,
                                       String patientName,
                                       String doctorName,
                                       String clinicName) {
        return String.format("%s;%s;%s;%s;%s\n", schedulingData, specialty, patientName, doctorName, clinicName);
    }

}
