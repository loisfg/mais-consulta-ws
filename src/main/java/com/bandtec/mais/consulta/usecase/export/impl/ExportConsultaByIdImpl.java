package com.bandtec.mais.consulta.usecase.export.impl;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.usecase.export.ExportConsultaById;
import com.bandtec.mais.consulta.usecase.export.utils.BuildExportArquivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ExportConsultaByIdImpl implements ExportConsultaById {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Map<String, String>> execute(Integer idAgendamento, Integer idUser) {

        if (usuarioRepository.existsById(idUser) && agendamentoRepository.existsById(idAgendamento)) {

            Optional<Scheduling> oAgendamento = agendamentoRepository.findByIdAgendamento(idAgendamento);

            if (oAgendamento.isEmpty()) {
                return Optional.empty();
            }

            Map<String, String> dadosArquivoAgendamento = BuildExportArquivo.buildDadosArquivoAgendamento(oAgendamento.get());

            return Optional.of(dadosArquivoAgendamento);
        }

        return Optional.empty();
    }
}
