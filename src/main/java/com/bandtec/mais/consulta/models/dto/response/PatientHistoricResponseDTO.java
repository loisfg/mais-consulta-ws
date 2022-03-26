package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.utils.StrFormat;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class PatientHistoricResponseDTO {
    Integer schedulingId;
    LocalDate schedulingDate;
    LocalTime schedulingTime;
    String specialty;
    String doctorName;
    String ubsName;

    public PatientHistoricResponseDTO(Integer schedulingId,
                                      LocalDate schedulingDate,
                                      LocalTime schedulingTime,
                                      String specialty,
                                      String doctorName,
                                      String ubsName) {
        this.schedulingId = schedulingId;
        this.schedulingDate = schedulingDate;
        this.schedulingTime = schedulingTime;
        this.specialty = specialty;
        this.doctorName = doctorName;
        this.ubsName = StrFormat.toTitledCase(ubsName);
    }
}
