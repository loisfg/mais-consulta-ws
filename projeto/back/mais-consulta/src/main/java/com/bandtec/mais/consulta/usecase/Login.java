package com.bandtec.mais.consulta.usecase;

import com.bandtec.mais.consulta.controller.dto.request.UsuarioRequestDTO;
import com.bandtec.mais.consulta.controller.dto.response.UsuarioResponseDTO;

public interface Login {
    UsuarioResponseDTO execute(UsuarioRequestDTO usuarioRequestDTO);
}
