package com.bandtec.mais.consulta.usecase;

import com.bandtec.mais.consulta.controller.dto.request.UsuarioRequestDTO;

public interface Logoff {
    Void execute(UsuarioRequestDTO usuarioRequestDTO);
}
