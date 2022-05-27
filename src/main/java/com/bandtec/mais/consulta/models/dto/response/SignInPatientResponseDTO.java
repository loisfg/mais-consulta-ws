package com.bandtec.mais.consulta.models.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInPatientResponseDTO {

    private Integer id;
    private String role;
    private String name;

}
