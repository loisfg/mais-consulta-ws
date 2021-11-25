package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.GetHorariosLivres;
import com.bandtec.mais.consulta.models.dto.response.AgendamentoConsultaResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.AgendamentoExameResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.*;
import com.bandtec.mais.consulta.usecase.ubs.PostHoursUbs;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@CrossOrigin("*")
@RestController
@RequestMapping("agendamento")
public class AgendamentoController {

    @Autowired
    private PostAgendamentoConsulta postAgendamentoConsulta;

    @Autowired
    private PostAgendamentoExame postAgendamentoExame;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private GetAgendamentoExame getAgendamentoExame;

    @Autowired
    private GetAgendamentoConsulta getAgendamentoConsulta;

    @Autowired
    private CancelAgendamento cancelAgendamento;

    @Autowired
    private PostHoursUbs postHoursUbs;

    @PatchMapping("/cancelar/{idAgendamento}/{idPaciente}")
    public ResponseEntity<?> cancelarExame(@PathVariable Integer idAgendamento,
                                           @PathVariable Integer idPaciente) {
        return ResponseEntity.ok(cancelAgendamento.execute(idPaciente, idAgendamento));
    }

    @PostMapping("/agendar/exame")
    public ResponseEntity<Exame> createAgendamentoExame(
            @RequestBody AgendamentoExameRequestDTO agendamentoExameRequestDTO
    ) {

        Optional<Exame> oExame = postAgendamentoExame.execute(agendamentoExameRequestDTO);

        return oExame
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @PostMapping("/agendar/consulta")
    public ResponseEntity<Consulta> createAgendamentoConsulta(
            @RequestBody AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO
    ) {

        Optional<Consulta> oConsulta = postAgendamentoConsulta.execute(agendamentoConsultaRequestDTO);

        return oConsulta
                .map(ResponseEntity.status(HttpStatus.CREATED)::body)
                .orElseGet(ResponseEntity.status(HttpStatus.BAD_REQUEST)::build);
    }

    @GetMapping("/buscar/exames/{idUser}")
    public ResponseEntity<?> getExamesByIdUser(@PathVariable Integer idUser) {

        Optional<List<AgendamentoExameResponseDTO>> oListExames = getAgendamentoExame.execute(idUser);

        return oListExames
                .map(ResponseEntity.status(HttpStatus.OK)::body)
                .orElseGet(ResponseEntity.status(HttpStatus.NO_CONTENT)::build);
    }

    @GetMapping("/buscar/consulta/{idUser}")
    public ResponseEntity<?> getConsultaByIdUser(@PathVariable Integer idUser) {

        Optional<List<AgendamentoConsultaResponseDTO>> oListConsultas = getAgendamentoConsulta.execute(idUser);

        return oListConsultas
                .map(ResponseEntity.status(HttpStatus.OK)::body)
                .orElseGet(ResponseEntity.status(HttpStatus.NO_CONTENT)::build);
    }

    @GetMapping("buscar/horarios/livres")
    public ResponseEntity<List<LocalTime>> getAvaibleTime(@RequestBody GetHorariosLivres getHorariosLivres) {
        List<LocalTime> listHoras = postHoursUbs.execute(getHorariosLivres);
        if(listHoras.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(listHoras);
    }
}
