package com.bandtec.mais.consulta.usecase.calendar;

import java.time.LocalDate;
import java.util.Date;

public interface GetCalendarLastDay {
    Date execute(Integer mesAno);
}
