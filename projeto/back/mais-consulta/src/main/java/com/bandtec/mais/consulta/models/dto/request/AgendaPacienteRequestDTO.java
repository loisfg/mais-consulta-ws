package com.bandtec.mais.consulta.models.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AgendaPacienteRequestDTO {

    Integer idPaciente;
    LocalDate dtStart;
    LocalDate dtEnd;
}
