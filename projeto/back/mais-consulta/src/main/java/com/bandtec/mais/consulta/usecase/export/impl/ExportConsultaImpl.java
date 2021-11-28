package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.usecase.export.ExportConsulta;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExportConsultaImpl implements ExportConsulta {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<String> execute(Integer idUser) {

        if (usuarioRepository.existsById(idUser)) {

            List<Agendamento> agendamentoList = agendamentoRepository.findByPaciente_Usuario_IdUsuario(idUser);

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

        agendamentoList.forEach(agendamento -> {
            Integer id = agendamento.getIdAgendamento();
            String especialidade = agendamento.getEspecialidade().getDescricao();
            LocalDate dataAtendimento = agendamento.getDtAtendimento();
            Paciente paciente = agendamento.getPaciente();
            String nomePaciente = paciente.getNome();
            String numeroCarteiraSus = paciente.getNumeroCarteiraSus();
            String status = agendamento.getStatus();
            Medico medico = agendamento.getMedico();
            String nomeMedico = medico.getNome();
            texto.append(buildTextoAgendamento(id, especialidade, dataAtendimento, nomePaciente, numeroCarteiraSus, status, nomeMedico));
        });

        return texto.toString();
//        return createResponseMap(id, dataAtendimento, nomePaciente, texto.toString());
    }

    @NotNull
    private Map<String, String> createResponseMap(Integer id, LocalDate dataAtendimento, String nomePaciente, String texto) {
        Map<String, String> dadosArquivoAgendamento = new HashMap<>();
        dadosArquivoAgendamento.put("informacoesConsulta", texto);
        dadosArquivoAgendamento.put("nomeArquivo", String.format("%s_%s_%d", nomePaciente.replace(" ", ""), dataAtendimento, id));
        return dadosArquivoAgendamento;
    }

    @NotNull
    private String buildTextoAgendamento(Integer id, String especialidade, LocalDate dataAtendimento, String nomePaciente, String numeroCarteiraSus, String status, String nomeMedico) {
        return String.format("%s;%s;%s;%s;%s;%s;%s\n", id, dataAtendimento, especialidade, nomePaciente, numeroCarteiraSus, status, nomeMedico);
    }

}
