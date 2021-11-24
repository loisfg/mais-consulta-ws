package com.bandtec.mais.consulta.models.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class GetHorariosLivres {
    private Integer idEspecialidade;
    private Integer idUbs;
    private LocalDate dia;
}
