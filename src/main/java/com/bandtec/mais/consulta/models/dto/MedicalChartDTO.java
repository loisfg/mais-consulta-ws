package com.bandtec.mais.consulta.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MedicalChartDTO {
    private String weight = "";
    private Double height = 0.0;
}
