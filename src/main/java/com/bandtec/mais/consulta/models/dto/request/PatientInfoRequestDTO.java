package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientInfoRequestDTO {

    private PersonalDataDTO personalData;
    private MedicalChartRequestDTO medicalChart;
    private DiagnosisDTO diagnosis;
}
