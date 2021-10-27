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

    public static Usuario convertFromController(PacienteSignUpRequestDTO pacienteSignUpRequestDTO) {
        return Usuario
                .builder()
                .setCpf(pacienteSignUpRequestDTO.getCpf())
                .setEmail(pacienteSignUpRequestDTO.getEmail())
                .setPassword(pacienteSignUpRequestDTO.getPassword())
                .build();
    }
}
