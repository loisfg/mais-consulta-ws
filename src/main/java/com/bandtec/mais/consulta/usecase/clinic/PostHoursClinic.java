package com.bandtec.mais.consulta.usecase.clinic;


import java.time.LocalTime;
import java.util.HashMap;

public interface PostHoursClinic {
    HashMap<LocalTime, String> execute(Integer clinicId, String day);
}
