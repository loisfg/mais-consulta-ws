package com.bandtec.mais.consulta.usecase.calendar.impl;

import com.bandtec.mais.consulta.models.dto.request.CalendarRequestDTO;
import com.bandtec.mais.consulta.usecase.calendar.GetCalendarDays;
import com.bandtec.mais.consulta.utils.CalendarService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCalendarDaysImpl implements GetCalendarDays {

    @SneakyThrows
    @Override
    public List<String> execute(CalendarRequestDTO calendarRequestDTO) {
        return CalendarService.getInstance().arrayDate(calendarRequestDTO.getDtInit(), calendarRequestDTO.getDtEnd());
    }
}
