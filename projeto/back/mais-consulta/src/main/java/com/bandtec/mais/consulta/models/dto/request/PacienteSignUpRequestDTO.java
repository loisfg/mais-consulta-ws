package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PacienteSignUpRequestDTO {
    private String cpf;
    private String email;
    protected String password;
    private Paciente paciente;
    private String role = "PACIENTE";

    public static Usuario convertFromController(PacienteSignUpRequestDTO pacienteSignUpRequestDTO) {
        return Usuario
                .builder()
                .cpf(pacienteSignUpRequestDTO.getCpf())
                .email(pacienteSignUpRequestDTO.getEmail())
                .password(pacienteSignUpRequestDTO.getPassword())
                .role(pacienteSignUpRequestDTO.getRole())
                .build();
    }
}
