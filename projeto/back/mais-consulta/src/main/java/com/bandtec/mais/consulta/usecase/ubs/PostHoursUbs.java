package com.bandtec.mais.consulta.usecase.ubs;

import com.bandtec.mais.consulta.domain.Data;
import com.bandtec.mais.consulta.domain.Hora;

import java.time.LocalDate;

public interface PostHoursUbs {
    LocalDate execute(Integer idUbs, Data data, Hora hora);
}
