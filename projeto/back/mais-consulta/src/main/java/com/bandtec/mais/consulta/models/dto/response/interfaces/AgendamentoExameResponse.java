package com.bandtec.mais.consulta.models.dto.response.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AgendamentoExameResponse {
    String getDescricao();
    LocalDate getDtAtendimento();
    LocalTime getHrAtendimento();
    String getEspecialidades();
}
