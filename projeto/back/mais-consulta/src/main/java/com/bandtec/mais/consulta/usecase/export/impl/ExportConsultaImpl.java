package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.usecase.export.ExportConsulta;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExportConsultaImpl implements ExportConsulta {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<String> execute(Integer idPaciente) {

        if (usuarioRepository.existsById(idPaciente)) {

            List<Agendamento> agendamentoList = agendamentoRepository.findByAgendamentoByPacienteId(idPaciente);

            if (agendamentoList.isEmpty()) {
                return Optional.empty();
            }

            String dadosArquivoAgendamento = buildDadosArquivoAgendamento(agendamentoList);

            return Optional.of(dadosArquivoAgendamento);
        }

        return Optional.empty();
    }

    public String buildDadosArquivoAgendamento(List<Agendamento> agendamentoList) {

        StringBuilder texto = new StringBuilder();
        String cabecalho = "data do atendimento;especialidade da consulta;nome do paciente;nome do medico;nome da ubs\n";
        texto.append(cabecalho);
        agendamentoList.forEach(agendamento -> {
            String especialidade = agendamento.getEspecialidade().getDescricao();
            LocalDate dataAtendimento = agendamento.getDtAtendimento();
            Paciente paciente = agendamento.getPaciente();
            String nomePaciente = paciente.getNome();
            Medico medico = agendamento.getMedico();
            String nomeMedico = medico.getNome();
            Ubs ubs = medico.getUbs();
            String nomeUbs = ubs.getNome();
            texto.append(buildTextoAgendamento(especialidade, dataAtendimento, nomePaciente, nomeMedico, nomeUbs));
        });

        return texto.toString();
    }

    @NotNull
    private String buildTextoAgendamento(String especialidade, LocalDate dataAtendimento, String nomePaciente, String nomeMedico, String nomeUbs) {
        return String.format("%s;%s;%s;%s;%s\n", dataAtendimento, especialidade, nomePaciente, nomeMedico, nomeUbs);
    }

}
