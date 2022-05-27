package com.bandtec.mais.consulta.models.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignInUserRequestDTO {
    private String cpf;
    private String password;
}
