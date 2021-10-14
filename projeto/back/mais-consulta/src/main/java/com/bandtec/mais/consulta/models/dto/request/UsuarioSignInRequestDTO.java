package com.bandtec.mais.consulta.models.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioSignInRequestDTO {
    private String cpf;
    private String password;
}
