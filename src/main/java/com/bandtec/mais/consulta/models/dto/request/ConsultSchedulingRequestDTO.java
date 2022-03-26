package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Scheduling;
import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class ConsultSchedulingRequestDTO {
    LocalDate schedulingDate;
    LocalTime schedulingTime;
    String description;
    Integer specialtyId;
    Integer patientId;
    Integer ubsId;
    SchedulingStatusEnum status;

    public static Consult convertFromController(ConsultSchedulingRequestDTO consultSchedulingRequestDTO) {
        log.info("DTO Consult {}", consultSchedulingRequestDTO);

        Scheduling scheduling = Scheduling.builder()
                .insertDateTime(new Date())
                .schedulingDate(consultSchedulingRequestDTO.schedulingDate)
                .schedulingTime(consultSchedulingRequestDTO.schedulingTime)
                .status(consultSchedulingRequestDTO.status)
                .build();

        return Consult.builder().description(consultSchedulingRequestDTO.description).scheduling(scheduling).build();
    }
}
