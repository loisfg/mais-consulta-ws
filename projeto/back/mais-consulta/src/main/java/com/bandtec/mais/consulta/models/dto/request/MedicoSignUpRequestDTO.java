package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicoSignUpRequestDTO {
    private String cpf;
    private String email;
    protected String password;
    private Medico medico;

    public static Usuario convertFromController(MedicoSignUpRequestDTO medicoSignUpRequestDTO) {
        return new Usuario(
                medicoSignUpRequestDTO.getCpf(),
                medicoSignUpRequestDTO.getEmail(),
                medicoSignUpRequestDTO.getPassword()
        );
    }
}
