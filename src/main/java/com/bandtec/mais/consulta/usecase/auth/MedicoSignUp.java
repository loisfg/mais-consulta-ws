package com.bandtec.mais.consulta.usecase.auth;

import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.models.dto.request.SignUpDoctorRequestDTO;

import java.util.Optional;

public interface MedicoSignUp {
    Optional<User> execute(SignUpDoctorRequestDTO signUpDoctorRequestDTO);
}
