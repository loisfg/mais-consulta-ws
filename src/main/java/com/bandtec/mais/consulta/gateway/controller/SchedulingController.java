package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.domain.Exam;
import com.bandtec.mais.consulta.models.dto.request.ConsultSchedulingRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.ExamSchedulingRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.SpecialtyResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.*;
import com.bandtec.mais.consulta.usecase.ubs.PostHoursUbs;
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
    private PostSchedulingExam postSchedulingExam;

    @Autowired
    private GetSchedulingExam getSchedulingExam;

    @Autowired
    private GetSchedulingConsult getSchedulingConsult;

    @Autowired
    private CancelScheduling cancelScheduling;

    @Autowired
    private PostHoursUbs postHoursUbs;

    @Autowired
    private GetSpecialties getSpecialties;

    @PatchMapping("/cancelar/{idAgendamento}")
    public ResponseEntity<?> cancelExam(@PathVariable Integer schedulingId) {
        return ResponseEntity.ok(cancelScheduling.execute(schedulingId));
    }

    @PostMapping("/agendar/exame")
    public ResponseEntity<Exam> createSchedulingExam(
            @RequestBody ExamSchedulingRequestDTO examSchedulingRequestDTO
    ) {
        return postSchedulingExam.execute(examSchedulingRequestDTO)
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @PostMapping("/agendar/consulta")
    public ResponseEntity<Consult> createSchedulingConsult(
            @RequestBody @Valid ConsultSchedulingRequestDTO consultSchedulingRequestDTO
    ) {
        return postSchedulingConsult.execute(consultSchedulingRequestDTO)
                .map(ResponseEntity.status(HttpStatus.CREATED)::body)
                .orElseGet(ResponseEntity.status(HttpStatus.BAD_REQUEST)::build);
    }

    @GetMapping("/exames/{idUser}")
    public ResponseEntity<?> getExamsByUser(@PathVariable Integer userId) {
        return getSchedulingExam.execute(userId)
                .map(ResponseEntity.status(HttpStatus.OK)::body)
                .orElseGet(ResponseEntity.status(HttpStatus.NO_CONTENT)::build);
    }

    @GetMapping("/consulta/{idUser}")
    public ResponseEntity<?> getConsultByUserId(@PathVariable Integer userId) {
        return getSchedulingConsult.execute(userId)
                .map(ResponseEntity.status(HttpStatus.OK)::body)
                .orElseGet(ResponseEntity.status(HttpStatus.NO_CONTENT)::build);
    }

    @GetMapping("/horarios/livres/{dia}/{idUbs}")
    public ResponseEntity<HashMap<LocalTime, String>> getAvailableTime(@PathVariable Integer ubsId,
                                                                       @PathVariable String day) {
        HashMap<LocalTime, String> hoursList = postHoursUbs.execute(ubsId, day);
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
