package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.models.dto.CalendarRequestDTO;
import com.bandtec.mais.consulta.usecase.calendar.GetCalendarDiasCorridos;
import com.bandtec.mais.consulta.usecase.calendar.GetCalendarLastDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("calendario")
public class CalendarController {

    @Autowired
    GetCalendarLastDay getCalendarLastDay;

    @Autowired
    GetCalendarDiasCorridos getCalendarDiasCorridos;

    @GetMapping("/ultimo-dia/{mesAno}")
    public Date ultimoDiaMes (@PathVariable Integer mesAno) {
        return getCalendarLastDay.execute(mesAno);
    }

    @GetMapping("/dias-corridos")
    public List<String> diasCorridos(@RequestBody CalendarRequestDTO calendarRequestDTO) {
        return getCalendarDiasCorridos.execute(calendarRequestDTO);
    }
}
