package com.bandtec.mais.consulta.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DiagnosisDTO {
    private String complaint;
    private String terminology;
    private String medicines;
    private String medicalGuidelines;
}
