package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class PatientHistoricMobileResponseDTO extends PatientHistoricResponseDTO {
    String street;
    String district;
    String state;
    SchedulingStatusEnum status;
    Integer patientId;

    public PatientHistoricMobileResponseDTO(
            String street,
            String district,
            String state,
            SchedulingStatusEnum status,
            Integer patientId,
            Integer schedulingId,
            LocalDate schedulingDate,
            LocalTime schedulingTime,
            String specialty,
            String doctorName,
            String clinicName
    ) {
        super(
                schedulingId,
                schedulingDate,
                schedulingTime,
                specialty,
                doctorName,
                clinicName);
        this.state = state;
        this.district = district;
        this.street = street;
        this.status = status;
        this.patientId = patientId;
    }
}
