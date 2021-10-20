package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.database.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.database.repository.UsuarioRepository;
import com.bandtec.mais.consulta.usecase.export.ExportAgendamento;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ExportAgendamentoImpl implements ExportAgendamento {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Map<String, String>> execute(Integer idUser, Integer idAgendamento) {

        if (usuarioRepository.existsById(idUser) && agendamentoRepository.existsById(idAgendamento)) {

            Agendamento agendamento = agendamentoRepository.findByIdAgendamento(idAgendamento).get();

            Map<String, String> dadosArquivoAgendamento = buildDadosArquivoAgendamento(agendamento);

            return Optional.of(dadosArquivoAgendamento);
        }

        return Optional.empty();
    }

    @NotNull
    private Map<String, String> buildDadosArquivoAgendamento(Agendamento agendamento) {

        Integer id = agendamento.getIdAgendamento();
        String especialidade = agendamento.getEspecialidade().getDescricao();
        LocalDate dataAtendimento = agendamento.getDtAtendimento();

        Medico medico = agendamento.getMedico();
        String nomeMedico = medico.getNome();
        String especialidadeMedico = medico.getEspecialidade().getDescricao();

        Paciente paciente = agendamento.getPaciente();
        String nomePaciente = paciente.getNome();
        String numeroCarteiraSus = paciente.getNumeroCarteiraSus();

        String texto = buildTextoAgendamento(id, especialidade, dataAtendimento, nomeMedico, especialidadeMedico, nomePaciente, numeroCarteiraSus);

        return createResponseMap(id, dataAtendimento, nomePaciente, texto);
    }

    @NotNull
    private Map<String, String> createResponseMap(Integer id, LocalDate dataAtendimento, String nomePaciente, String texto) {
        Map<String, String> dadosArquivoAgendamento = new HashMap<>();
        dadosArquivoAgendamento.put("informacoesAgendamento", texto);
        dadosArquivoAgendamento.put("nomeArquivo", String.format("%s_%s_%d", nomePaciente.replace(" ", ""), dataAtendimento, id));
        return dadosArquivoAgendamento;
    }

    @NotNull
    private String buildTextoAgendamento(Integer id, String especialidade, LocalDate dataAtendimento, String nomeMedico, String especialidadeMedico, String nomePaciente, String numeroCarteiraSus) {
        return String.format("%s;%s;%s;%s;%s;%s;%s\n", id, dataAtendimento, especialidade, nomeMedico, especialidadeMedico, nomePaciente, numeroCarteiraSus);
    }

}
