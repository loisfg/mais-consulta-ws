package com.bandtec.mais.consulta.usecase.ubs;


import java.time.LocalTime;
import java.util.List;

public interface PostHoursUbs {
    List<LocalTime> execute(Integer idUbs, String dia);
}
