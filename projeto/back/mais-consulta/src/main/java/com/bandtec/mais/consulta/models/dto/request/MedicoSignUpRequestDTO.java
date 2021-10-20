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
        Usuario usuario = new Usuario();

        usuario.setEmail(medicoSignUpRequestDTO.getEmail());
        usuario.setCpf(medicoSignUpRequestDTO.getCpf());
        usuario.setPassword(medicoSignUpRequestDTO.getPassword());

        return usuario;
    }
}
