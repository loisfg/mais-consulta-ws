package com.bandtec.mais.consulta.usecase;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.UsuarioRequestDTO;

import java.util.List;
import java.util.Optional;

public interface Login {
    Optional<Usuario> execute(UsuarioRequestDTO usuarioRequestDTO, List<Usuario> usuariosLogados);
}
