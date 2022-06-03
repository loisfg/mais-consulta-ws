package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import com.bandtec.mais.consulta.models.dto.MedicalChartDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientInfoResponseDTO {
    public PersonalDataDTO personalData;
    public MedicalChartDTO medicalChart;
}
