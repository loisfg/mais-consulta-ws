package com.bandtec.mais.consulta.models.dto.response;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class PatientHistoricMobileResponseDTO extends PatientHistoricResponseDTO {
    String street;
    String district;
    String state;

    public PatientHistoricMobileResponseDTO(
            String street,
            String district,
            String state,
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
    }
}
