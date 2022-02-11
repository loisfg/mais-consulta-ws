package com.bandtec.mais.consulta.usecase.auth;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.PacienteSignUpRequestDTO;

import java.util.Optional;

public interface PacienteSignup {
    Optional<Usuario> execute(PacienteSignUpRequestDTO pacienteSignUpRequestDTO);
}
