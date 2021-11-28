package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
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
    public Optional<Map<String, String>> execute(Integer idUser) {

        if (usuarioRepository.existsById(idUser)) {

            Optional<Agendamento> oAgendamento = agendamentoRepository.findFirstByPaciente_Usuario_IdUsuarioOrderByDtAtendimentoDesc(idUser);

            if (oAgendamento.isEmpty()) {
                return Optional.empty();
            }

            Map<String, String> dadosArquivoAgendamento = buildDadosArquivoAgendamento(oAgendamento.get());

            return Optional.of(dadosArquivoAgendamento);
        }

        return Optional.empty();
    }

    @NotNull
    private Map<String, String> buildDadosArquivoAgendamento(Agendamento agendamento) {

        Integer id = agendamento.getIdAgendamento();
        String especialidade = agendamento.getEspecialidade().getDescricao();
        LocalDate dataAtendimento = agendamento.getDtAtendimento();

        Paciente paciente = agendamento.getPaciente();
        String nomePaciente = paciente.getNome();
        String numeroCarteiraSus = paciente.getNumeroCarteiraSus();

        String texto = buildTextoAgendamento(id, especialidade, dataAtendimento, nomePaciente, numeroCarteiraSus);

        return createResponseMap(id, dataAtendimento, nomePaciente, texto);
    }

    @NotNull
    private Map<String, String> createResponseMap(Integer id, LocalDate dataAtendimento, String nomePaciente, String texto) {
        Map<String, String> dadosArquivoAgendamento = new HashMap<>();
        dadosArquivoAgendamento.put("informacoesConsulta", texto);
        dadosArquivoAgendamento.put("nomeArquivo", String.format("%s_%s_%d", nomePaciente.replace(" ", ""), dataAtendimento, id));
        return dadosArquivoAgendamento;
    }

    @NotNull
    private String buildTextoAgendamento(Integer id, String especialidade, LocalDate dataAtendimento, String nomePaciente, String numeroCarteiraSus) {
        return String.format("%s;%s;%s;%s;%s\n", id, dataAtendimento, especialidade, nomePaciente, numeroCarteiraSus);
    }

}
