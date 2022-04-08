package com.bandtec.mais.consulta.usecase.clinic.impl;

import com.bandtec.mais.consulta.gateway.repository.SchedulingRepository;
import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.models.dto.response.HoursResponseDTO;
import com.bandtec.mais.consulta.usecase.clinic.PostHoursClinic;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class PostHoursClinicImpl implements PostHoursClinic {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    SchedulingRepository schedulingRepository;

    @SneakyThrows
    @Override
    public HashMap<LocalTime, String> execute(Integer clinicId, String day) {
        List<HoursResponseDTO> listHoursOccupied = schedulingRepository
                .findTimeAndSchedulingDateByClinicId(clinicId, LocalDate.parse(day));
        List<LocalTime> workingHours = addHours();
        LinkedHashMap<LocalTime, String> hours = new LinkedHashMap<>();

        workingHours.forEach(workingHour -> {
            hours.put(workingHour, "Livre");
            listHoursOccupied.forEach(hourOccupied -> {
                        if (hours.containsKey(hourOccupied.getSchedulingTime())) {
                            hours.replace(hourOccupied.getSchedulingTime(), "Ocupado");
                        }
                    }
            );
        });

        return hours;
    }

    public List<LocalTime> addHours() {
        List<LocalTime> allHours = new ArrayList<>();
        List<Integer> hrs = List.of(8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
        try {
            for (Integer hr : hrs) {
                allHours.add(LocalTime.of(hr, 0));
                allHours.add(LocalTime.of(hr, 30));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return allHours;
    }
}