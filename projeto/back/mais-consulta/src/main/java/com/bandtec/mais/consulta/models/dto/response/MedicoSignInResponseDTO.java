package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.domain.Medico;
import lombok.Data;

@Data
public class MedicoSignInResponseDTO {

    private String cpf;
    private String email;
    private Medico medico;

}

