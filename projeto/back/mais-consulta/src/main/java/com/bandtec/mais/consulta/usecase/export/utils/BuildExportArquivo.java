package com.bandtec.mais.consulta.usecase.export.utils;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Paciente;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class BuildExportArquivo {

    @NotNull
    public static Map<String, String> buildDadosArquivoAgendamento(Agendamento agendamento) {

        Integer id = agendamento.getIdAgendamento();
        String especialidade = agendamento.getEspecialidade().getDescricao();
        LocalDate dataAtendimento = agendamento.getDtAtendimento();

        Paciente paciente = agendamento.getPaciente();
        String nomePaciente = paciente.getNome();
        String numeroCarteiraSus = paciente.getNumeroCarteiraSus();

        String status = agendamento.getStatus();

        Medico medico = agendamento.getMedico();
        String nomeMedico = medico.getNome();

        String texto = buildTextoAgendamento(id, especialidade, dataAtendimento, nomePaciente, numeroCarteiraSus, status, nomeMedico);

        return createResponseMap(id, dataAtendimento, nomePaciente, texto);
    }

    @NotNull
    private static Map<String, String> createResponseMap(Integer id, LocalDate dataAtendimento, String nomePaciente, String texto) {
        Map<String, String> dadosArquivoAgendamento = new HashMap<>();
        dadosArquivoAgendamento.put("informacoesConsulta", texto);
        dadosArquivoAgendamento.put("nomeArquivo", String.format("%s_%s_%d", nomePaciente.replace(" ", ""), dataAtendimento, id));
        return dadosArquivoAgendamento;
    }

    @NotNull
    private static String buildTextoAgendamento(Integer id, String especialidade, LocalDate dataAtendimento, String nomePaciente, String numeroCarteiraSus, String status, String nomeMedico) {
        return String.format("%s;%s;%s;%s;%s;%s;%s\n", id, dataAtendimento, especialidade, nomePaciente, numeroCarteiraSus, status, nomeMedico);
    }

}