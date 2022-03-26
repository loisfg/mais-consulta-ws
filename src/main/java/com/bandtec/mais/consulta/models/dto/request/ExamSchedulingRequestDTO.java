package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.domain.Exam;
import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class ExamSchedulingRequestDTO {
    LocalDate schedulingDate;
    LocalTime schedulingTime;
    String description;
    Integer specialtyId;
    Integer patientId;
    Integer ubsId;
    SchedulingStatusEnum status;

    public static Exam convertFromController(ExamSchedulingRequestDTO examSchedulingRequestDTO) {

        Scheduling scheduling = Scheduling
                .builder()
                .schedulingTime(examSchedulingRequestDTO.schedulingTime)
                .schedulingDate(examSchedulingRequestDTO.schedulingDate)
                .status(examSchedulingRequestDTO.status)
                .build();

        return Exam
                .builder()
                .description(examSchedulingRequestDTO.description)
                .scheduling(scheduling)
                .build();
    }
}
