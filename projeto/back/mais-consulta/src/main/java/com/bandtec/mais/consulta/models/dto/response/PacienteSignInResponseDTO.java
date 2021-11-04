package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.domain.Paciente;
import lombok.Data;

@Data
public class PacienteSignInResponseDTO {

    private String cpf;
    private String email;
    private Paciente paciente;

}
