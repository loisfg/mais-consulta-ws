package com.bandtec.mais.consulta.usecase.calendar.impl;

import com.bandtec.mais.consulta.models.dto.CalendarRequestDTO;
import com.bandtec.mais.consulta.usecase.calendar.GetCalendarDiasCorridos;
import com.bandtec.mais.consulta.utils.CalendarService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class GetCalendarDiasCorridosImpl implements GetCalendarDiasCorridos {

    @SneakyThrows
    @Override
    public Integer execute(CalendarRequestDTO calendarRequestDTO) {
        return CalendarService.getInstance().getDiasCorridos(
                calendarRequestDTO.getDtInit(),
                calendarRequestDTO.getDtEnd(),
                calendarRequestDTO.getFormat()
        );
    }
}
