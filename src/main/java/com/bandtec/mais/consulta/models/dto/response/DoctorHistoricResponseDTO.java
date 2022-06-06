package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;

@Getter
public class DoctorHistoricResponseDTO {
    Integer schedulingId;
    String name;
    Integer age;
    LocalDate lastScheduling;
    SchedulingStatusEnum status;

    public DoctorHistoricResponseDTO(Integer schedulingId,
                                     String name,
                                     LocalDate dataNascimento,
                                     LocalDate schedulingDate,
                                     SchedulingStatusEnum status) {
        this.schedulingId = schedulingId;
        this.name = name;
        this.age = calculateAge(dataNascimento);
        this.lastScheduling = schedulingDate;
        this.status = status;
    }

    public static Integer calculateAge(LocalDate birthDate) {
        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}
