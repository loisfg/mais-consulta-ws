package com.bandtec.mais.consulta.models.dto;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.models.enums.BloodTypeEnum;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MedicalChartDTO {
    private String weight = "";
    private Double height = 0.0;
    private List<Disease> chronicDiseases;
    private List<Medicine> prescriptionDrugs;
    private List<Allergy> allergies;
    private List<Disease> stds;
    private List<Deficiency> deficiency;
    private boolean isSmoker = false;
    private boolean isVirgin = false;
    private List<Disease> hereditaryDiseases;
    private BloodTypeEnum bloodType = BloodTypeEnum.DEFAULT;
    private List<Activity> prohibitedActivities;
}
