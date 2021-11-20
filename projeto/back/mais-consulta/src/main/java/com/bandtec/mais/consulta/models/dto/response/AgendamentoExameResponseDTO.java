package com.bandtec.mais.consulta.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class AgendamentoExameResponseDTO {

    String descricao;
    LocalDate dtAtendimento;
    LocalTime hrAtendimento;
    String especialidades;

}
