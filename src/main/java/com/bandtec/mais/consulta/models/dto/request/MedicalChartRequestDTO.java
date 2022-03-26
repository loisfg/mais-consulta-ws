package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.models.enums.BloodTypeEnum;
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
    private Iterable<Integer> diseases = null;
    private Iterable<Integer> medicines = null;
    private Iterable<Integer> allergies = null;
    private Iterable<Integer> deficiencies = null;
    private Iterable<Integer> prohibitedActivities = null;
    private boolean isSmoker = false;
    private boolean isVirgin = false;
    private BloodTypeEnum bloodType = BloodTypeEnum.DEFAULT;
}
