package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignUpPatientRequestDTO {
    private String cpf;
    private String email;
    protected String password;
    private Patient patient;
    private String birthDate;
    private String role = "Paciente";

    public static User convertFromController(SignUpPatientRequestDTO signUpPatientRequestDTO) {
        return User
                .builder()
                .cpf(signUpPatientRequestDTO.getCpf())
                .email(signUpPatientRequestDTO.getEmail())
                .password(signUpPatientRequestDTO.getPassword())
                .role(signUpPatientRequestDTO.getRole())
                .build();
    }
}
