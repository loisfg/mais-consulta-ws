package com.bandtec.mais.consulta.usecase.export.impl;


import com.bandtec.mais.consulta.gateway.repository.AgendamentoRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ExportAgendamentoTxt implements ExportTxt {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Map<String, String>> execute(Integer idUser, Integer idAgendamento) {


        return Optional.empty();
    }
}
