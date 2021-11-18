package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.domain.Paciente;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PacienteSignInResponseDTO {

    private Integer id;
    private String role;
    private String nome;

}
