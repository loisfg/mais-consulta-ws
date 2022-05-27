package com.bandtec.mais.consulta.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class HoursResponseDTO {
    private LocalDate schedulingDate;
    private LocalTime schedulingTime;
    private Integer doctorId;
}
