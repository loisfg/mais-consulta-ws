package com.bandtec.mais.consulta.usecase.auth;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.MedicoSignUpRequestDTO;

import java.util.Optional;

public interface MedicoSignUp {
    Optional<Usuario> execute(MedicoSignUpRequestDTO medicoSignUpRequestDTO);
}
