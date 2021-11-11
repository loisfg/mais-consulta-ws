package com.bandtec.mais.consulta.usecase.calendar;

import com.bandtec.mais.consulta.models.dto.request.CalendarRequestDTO;

import java.util.List;

public interface GetCalendarDiasCorridos {
    List<String> execute(CalendarRequestDTO calendarRequestDTO);
}
