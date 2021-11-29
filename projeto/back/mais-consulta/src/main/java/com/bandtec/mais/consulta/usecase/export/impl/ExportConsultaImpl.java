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

        agendamentoList.forEach(agendamento -> {
            String especialidade = agendamento.getEspecialidade().getDescricao();
            LocalDate dataAtendimento = agendamento.getDtAtendimento();
            Paciente paciente = agendamento.getPaciente();
            String nomePaciente = paciente.getNome();
            String numeroCarteiraSus = paciente.getNumeroCarteiraSus();
            String status = agendamento.getStatus();
            Medico medico = agendamento.getMedico();
            String nomeMedico = medico.getNome();
            texto.append(buildTextoAgendamento(especialidade, dataAtendimento, nomePaciente, numeroCarteiraSus, status, nomeMedico));
        });

        return texto.toString();
    }

    @NotNull
    private String buildTextoAgendamento(String especialidade, LocalDate dataAtendimento, String nomePaciente, String numeroCarteiraSus, String status, String nomeMedico) {
        return String.format("%s;%s;%s;%s;%s;%s\n", dataAtendimento, especialidade, nomePaciente, numeroCarteiraSus, status, nomeMedico);
    }

}
