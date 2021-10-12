package com.bandtec.mais.consulta.usecase.auth;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.UsuarioRequestDTO;

import java.util.List;

public interface Logoff {
    String execute(UsuarioRequestDTO usuarioRequestDTO, List<Usuario> usuariosLogados);
}
