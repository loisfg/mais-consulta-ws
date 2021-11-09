package com.bandtec.mais.consulta.usecase.calendar.impl;

import com.bandtec.mais.consulta.usecase.calendar.GetCalendarLastDay;
import com.bandtec.mais.consulta.utils.CalendarService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GetCalendarLastDayImpl implements GetCalendarLastDay {

    CalendarService calendar = CalendarService.getInstance();

    @SneakyThrows
    @Override
    public Date execute(Integer mesAno) {
        Integer lastDay = calendar.getUltimaDataDoMes(mesAno);

        return calendar.getIntToDate(lastDay);
    }
}
