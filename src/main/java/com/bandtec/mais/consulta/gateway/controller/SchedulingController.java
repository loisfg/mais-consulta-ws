package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.models.dto.request.ConsultSchedulingRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.SpecialtyResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.*;
import com.bandtec.mais.consulta.usecase.clinic.PostHoursClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("agendamento")
public class SchedulingController {

    @Autowired
    private PostSchedulingConsult postSchedulingConsult;

    @Autowired
    private GetSchedulingConsult getSchedulingConsult;

    @Autowired
    private CancelScheduling cancelScheduling;

    @Autowired
    private PostHoursClinic postHoursClinic;

    @Autowired
    private GetSpecialties getSpecialties;

    @PatchMapping("/cancelar/{schedulingId}")
    public ResponseEntity<?> cancelExam(@PathVariable Integer schedulingId) {
        return ResponseEntity.ok(cancelScheduling.execute(schedulingId));
    }

    @PostMapping("/agendar/consulta")
    public ResponseEntity<Consult> createSchedulingConsult(
            @RequestBody @Valid ConsultSchedulingRequestDTO consultSchedulingRequestDTO
    ) {
        return postSchedulingConsult.execute(consultSchedulingRequestDTO)
                .map(ResponseEntity.status(HttpStatus.CREATED)::body)
                .orElseGet(ResponseEntity.status(HttpStatus.BAD_REQUEST)::build);
    }

    @GetMapping("/consulta/{userId}")
    public ResponseEntity<?> getConsultByUserId(@PathVariable Integer userId) {
        return getSchedulingConsult.execute(userId)
                .map(ResponseEntity.status(HttpStatus.OK)::body)
                .orElseGet(ResponseEntity.status(HttpStatus.NO_CONTENT)::build);
    }

    @GetMapping("/horarios/livres/{day}/{clinicId}")
    public ResponseEntity<HashMap<LocalTime, String>> getAvailableTime(@PathVariable Integer clinicId,
                                                                       @PathVariable String day) {
        HashMap<LocalTime, String> hoursList = postHoursClinic.execute(clinicId, day);
        if (hoursList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(hoursList);
    }

    @GetMapping("/especialidades")
    public ResponseEntity<Set<SpecialtyResponseDTO>> getSpecialties() {
        return ResponseEntity.of(getSpecialties.execute());

    }

}
