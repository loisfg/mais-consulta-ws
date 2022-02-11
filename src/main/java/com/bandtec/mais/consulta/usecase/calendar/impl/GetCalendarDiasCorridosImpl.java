package com.bandtec.mais.consulta.usecase.calendar.impl;

import com.bandtec.mais.consulta.models.dto.request.CalendarRequestDTO;
import com.bandtec.mais.consulta.usecase.calendar.GetCalendarDiasCorridos;
import com.bandtec.mais.consulta.utils.CalendarService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCalendarDiasCorridosImpl implements GetCalendarDiasCorridos {

    @SneakyThrows
    @Override
    public List<String> execute(CalendarRequestDTO calendarRequestDTO) {
        return CalendarService.getInstance().arrayDate(calendarRequestDTO.getDtInit(), calendarRequestDTO.getDtEnd());
    }
}
