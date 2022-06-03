package com.bandtec.mais.consulta.models.dto.response;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class PatientSchedulingResponseDTO {
    Integer schedulingId;
    String specialty;
    LocalDate schedulingDate;
    String weekDays;
    LocalTime schedulingTime;

    public PatientSchedulingResponseDTO(Integer schedulingId,
                                        String specialty,
                                        LocalDate schedulingDate,
                                        LocalTime schedulingTime) {
        this.schedulingId = schedulingId;
        this.specialty = specialty;
        this.schedulingDate = schedulingDate;
        this.weekDays = getWeekDays(schedulingDate);
        this.schedulingTime = schedulingTime;
    }

    private String getWeekDays(LocalDate schedulingDate) {
        switch (schedulingDate.getDayOfWeek()) {
            case MONDAY:
                return "Segunda";
            case TUESDAY:
                return "Terça";
            case WEDNESDAY:
                return "Quarta";
            case THURSDAY:
                return "Quinta";
            case FRIDAY:
                return "Sexta";
            case SATURDAY:
                return "Sabádo";
            case SUNDAY:
                return "Domingo";
            default:
                return "Dia inexistente";
        }
    }

}