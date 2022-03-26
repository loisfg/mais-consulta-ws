package com.bandtec.mais.consulta.usecase.auth;

import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.models.dto.request.SignUpPatientRequestDTO;

import java.util.Optional;

public interface PacienteSignup {
    Optional<User> execute(SignUpPatientRequestDTO signUpPatientRequestDTO);
}
