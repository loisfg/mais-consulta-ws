package com.bandtec.mais.consulta.models.dto.response;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

@Getter
public class DoctorSchedulingDTO {

    Integer patientId;
    Integer schedulingId;
    String name;
    Integer age;
    LocalTime schedulingTime;

    public DoctorSchedulingDTO(Integer patientId,
                               Integer schedulingId,
                               String name,
                               LocalTime schedulingTime,
                               LocalDate birthDate) {
        this.patientId = patientId;
        this.schedulingId = schedulingId;
        this.name = name;
        this.age = calculateAge(birthDate);
        this.schedulingTime = schedulingTime;
    }

    public static Integer calculateAge(LocalDate birthDate) {
        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}
