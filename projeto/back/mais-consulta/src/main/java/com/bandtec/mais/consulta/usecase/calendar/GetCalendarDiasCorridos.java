package com.bandtec.mais.consulta.usecase.calendar;

import com.bandtec.mais.consulta.models.dto.CalendarRequestDTO;

import java.util.Calendar;
import java.util.List;

public interface GetCalendarDiasCorridos {
    List<String> execute(CalendarRequestDTO calendarRequestDTO);
}
