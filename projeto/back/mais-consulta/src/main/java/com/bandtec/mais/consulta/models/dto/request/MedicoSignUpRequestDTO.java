package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Medico;
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
    private String telefone;
    private Medico medico;
}
