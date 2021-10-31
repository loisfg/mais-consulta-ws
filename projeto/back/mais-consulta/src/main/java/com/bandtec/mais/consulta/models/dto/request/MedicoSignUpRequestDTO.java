package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class MedicoSignUpRequestDTO {
    private String cpf;
    private String email;
    protected String password;
    private Medico medico;

    public static Usuario convertFromController(MedicoSignUpRequestDTO medicoSignUpRequestDTO) {
        var usuario = Usuario
                .builder()
                .cpf(medicoSignUpRequestDTO.getCpf())
                .email(medicoSignUpRequestDTO.getEmail())
                .password(medicoSignUpRequestDTO.getPassword())
                .build();

        log.info("Convertendo request {} \n " +
                "para Usuário Medico {}", medicoSignUpRequestDTO, usuario);

        return usuario;
    }
}
