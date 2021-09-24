package com.bandtec.mais.consulta.usecase.impl;

import com.bandtec.mais.consulta.controller.dto.request.UsuarioRequestDTO;
import com.bandtec.mais.consulta.controller.dto.response.UsuarioResponseDTO;
import com.bandtec.mais.consulta.usecase.Login;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl implements Login {
    @Override
    public UsuarioResponseDTO execute(UsuarioRequestDTO usuarioRequestDTO) {
        return null;
    }
}
