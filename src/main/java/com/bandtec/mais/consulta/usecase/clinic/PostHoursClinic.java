package com.bandtec.mais.consulta.usecase.clinic;


import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public interface PostHoursClinic {
    HashMap<String, List<LocalTime>> execute(Integer clinicId, String day);
}
