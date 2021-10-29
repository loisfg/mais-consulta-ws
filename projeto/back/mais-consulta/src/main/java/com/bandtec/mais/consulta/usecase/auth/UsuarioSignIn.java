package com.bandtec.mais.consulta.usecase.auth;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignInRequestDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioSignIn {
    Optional<Usuario> execute(UsuarioSignInRequestDTO usuarioSignInRequestDTO, List<Usuario> usuariosLogados);
}