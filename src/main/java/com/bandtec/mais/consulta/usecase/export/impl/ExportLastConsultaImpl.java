package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.usecase.export.ExportLastConsulta;
import com.bandtec.mais.consulta.usecase.export.utils.BuildExportArquivo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ExportLastConsultaImpl implements ExportLastConsulta {

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

            Map<String, String> dadosArquivoAgendamento = BuildExportArquivo.buildDadosArquivoAgendamento(oAgendamento.get());

            return Optional.of(dadosArquivoAgendamento);
        }

        return Optional.empty();
    }

}
