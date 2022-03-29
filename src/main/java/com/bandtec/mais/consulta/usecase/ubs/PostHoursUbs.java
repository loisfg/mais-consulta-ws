package com.bandtec.mais.consulta.usecase.ubs;


import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public interface PostHoursUbs {
    HashMap<String, List<LocalTime>> execute(Integer idUbs, String dia);
}
