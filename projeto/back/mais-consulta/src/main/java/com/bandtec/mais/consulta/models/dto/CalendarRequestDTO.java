package com.bandtec.mais.consulta.models.dto;

import lombok.Data;

@Data
public class CalendarRequestDTO {
    Integer dtInit;
    Integer dtEnd;
    String format;
}
