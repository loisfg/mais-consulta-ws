package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.models.dto.PersonalDataDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class PatientInfoPutRequestDTO {
    public PersonalDataDTO personalData;
    public MedicalChartRequestDTO medicalChart;
}