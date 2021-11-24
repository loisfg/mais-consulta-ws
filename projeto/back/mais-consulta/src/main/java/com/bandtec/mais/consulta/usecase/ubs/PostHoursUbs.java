package com.bandtec.mais.consulta.usecase.ubs;


import com.bandtec.mais.consulta.models.dto.request.GetHorariosLivres;

import java.time.LocalTime;
import java.util.List;

public interface PostHoursUbs {
    List<LocalTime> execute(GetHorariosLivres getHorariosLivres);
}
