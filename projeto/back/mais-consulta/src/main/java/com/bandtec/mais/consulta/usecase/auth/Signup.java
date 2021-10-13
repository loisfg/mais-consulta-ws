package com.bandtec.mais.consulta.usecase.auth;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignUpRequestDTO;

import java.util.Optional;

public interface Signup {
    Optional<Usuario> execute(UsuarioSignUpRequestDTO usuarioSignUpRequestDTO);
}
