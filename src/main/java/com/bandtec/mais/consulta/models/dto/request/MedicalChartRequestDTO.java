package com.bandtec.mais.consulta.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalChartRequestDTO {
    private String weight = "";
    private Double height = 0.0;
}
