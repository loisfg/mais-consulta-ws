package com.bandtec.mais.consulta.usecase.impl;

import com.bandtec.mais.consulta.controller.dto.request.UsuarioRequestDTO;
import com.bandtec.mais.consulta.usecase.Logoff;
import org.springframework.stereotype.Service;

@Service
public class LogoffImpl implements Logoff {
    @Override
    public Void execute(UsuarioRequestDTO usuarioRequestDTO) {
        return null;
    }
}
