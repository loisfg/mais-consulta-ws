package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.domain.Medico;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class HoursResponseDTO {
    private LocalDate dtAtendimento;
    private LocalTime hrAtendimento;
    private Integer idMedico;
}
