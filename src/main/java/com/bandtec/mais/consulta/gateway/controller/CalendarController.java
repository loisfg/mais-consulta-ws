package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.models.dto.request.CalendarRequestDTO;
import com.bandtec.mais.consulta.usecase.calendar.GetCalendarDays;
import com.bandtec.mais.consulta.usecase.calendar.GetCalendarLastDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("calendario")
public class CalendarController {

    @Autowired
    GetCalendarLastDay getCalendarLastDay;

    @Autowired
    GetCalendarDays getCalendarDays;

    @GetMapping("/ultimo-dia/{mesAno}")
    public Date lastDayMonth(@PathVariable Integer monthYear) {
        return getCalendarLastDay.execute(monthYear);
    }

    @GetMapping("/dias-corridos")
    public List<String> calendarDays(@RequestBody CalendarRequestDTO calendarRequestDTO) {
        return getCalendarDays.execute(calendarRequestDTO);
    }
}
