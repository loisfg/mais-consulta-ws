package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.domain.Medico;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicoSignInResponseDTO {

    private Integer id;
    private String nome;
    private String role;

}

