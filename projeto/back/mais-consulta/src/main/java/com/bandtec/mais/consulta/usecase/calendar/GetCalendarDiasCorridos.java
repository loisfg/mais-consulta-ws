package com.bandtec.mais.consulta.usecase.calendar;

import com.bandtec.mais.consulta.models.dto.CalendarRequestDTO;

public interface GetCalendarDiasCorridos {
    Integer execute(CalendarRequestDTO calendarRequestDTO);
}
