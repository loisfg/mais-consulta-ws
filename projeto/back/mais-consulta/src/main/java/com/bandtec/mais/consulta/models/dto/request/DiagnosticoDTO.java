package com.bandtec.mais.consulta.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DiagnosticoDTO {
    private String queixa;
    private String terminologia;
    private String medicamentos;
    private String orientacoesMedicas;
}
