package com.bandtec.mais.consulta.usecase.auth;

import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.models.dto.request.SignInUserRequestDTO;

import java.util.List;
import java.util.Optional;

public interface SignIn {
    Optional<?> execute(SignInUserRequestDTO signInUserRequestDTO, List<User> usuariosLogados);
}
