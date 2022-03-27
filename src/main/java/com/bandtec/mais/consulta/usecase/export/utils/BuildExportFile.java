package com.bandtec.mais.consulta.usecase.export.utils;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BuildExportFile {

    @NotNull
    public static Map<String, String> buildDataSchedulingFile(Scheduling scheduling) {

        Integer id = scheduling.getSchedulingId();
        String specialty = scheduling.getSpecialty().getDescription();
        LocalDate schedulingDate = scheduling.getSchedulingDate();

        Patient patient = scheduling.getPatient();
        String patientName = patient.getName();

        String susNumberWallet = patient.getSusNumberWallet();

        SchedulingStatusEnum status = scheduling.getStatus();

        Doctor doctor = scheduling.getDoctor();
        String doctorName = doctor.getName();

        Ubs ubs = doctor.getUbs();
        String ubsName = ubs.getName();
        Address ubsAddress = ubs.getAddress();

        String ubsStreet = ubsAddress.getStreet();
        String ubsNumber = ubsAddress.getNumber();
        String ubsPhone = ubs.getPhone();

        String text = buildTextoAgendamento(id, specialty, schedulingDate, patientName, doctorName, ubsName);

        return createResponseMap(id, schedulingDate, patientName, text);
    }

    @NotNull
    private static Map<String, String> createResponseMap(Integer id, LocalDate dataAtendimento, String nomePaciente, String texto) {
        Map<String, String> dadosArquivoAgendamento = new HashMap<>();

        dadosArquivoAgendamento.put("informacoesConsulta", texto);
        dadosArquivoAgendamento.put("nomeArquivo", String.format("%s_%s_%d", nomePaciente.replace(" ", ""), dataAtendimento, id));
        return dadosArquivoAgendamento;
    }

    @NotNull
    private static String buildTextoAgendamento(Integer id,
                                                String specialty,
                                                LocalDate schedulingDate,
                                                String patientName,
                                                String doctorName,
                                                String ubsName) {
        String header = "id do agendamento;data do atendimento;especialidade da consulta;nome do paciente;nome do medico;nome da ubs\n";
        String body = String.format("%s;%s;%s;%s;%s;%s\n",
                id,
                schedulingDate,
                specialty,
                patientName,
                doctorName,
                ubsName);
        return header + body;
    }

}
