package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoConsulta;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoExame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("agendamento")
public class AgendamentoController {

    private final PostAgendamentoConsulta postAgendamentoConsulta;
    private final PostAgendamentoExame postAgendamentoExame;

    @Autowired
    public AgendamentoController(PostAgendamentoConsulta postAgendamentoConsulta, PostAgendamentoExame postAgendamentoExame) {
        this.postAgendamentoConsulta = postAgendamentoConsulta;
        this.postAgendamentoExame = postAgendamentoExame;
    }

    @PostMapping("/{idPaciente}/{idMedico}/{idUbs}/agendar/exame")
    public ResponseEntity<Exame> createAgendamentoExame(
            @Valid
            @PathVariable("idPaciente")Integer idPaciente,
            @PathVariable("idMedico") Integer idMedico,
            @PathVariable("idUbs") Integer idUbs,
            @RequestBody AgendamentoExameRequestDTO agendamentoExameRequestDTO
    ) {
        Optional<Exame> oExame = postAgendamentoExame.execute(agendamentoExameRequestDTO);

        return oExame
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @PostMapping("/{idPaciente}/{idMedico}/{idUbs}/agendar/consulta")
    public ResponseEntity<?> createAgendamentoConsulta(
            @PathVariable("idPaciente")Integer idPaciente,
            @PathVariable("idMedico") Integer idMedico,
            @PathVariable("idUbs") Integer idUbs,
            @RequestBody AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO
    ) {

        agendamentoConsultaRequestDTO.setIdPaciente(idPaciente);
        agendamentoConsultaRequestDTO.setIdMedico(idMedico);
        agendamentoConsultaRequestDTO.setIdUbs(idUbs);

        Optional<Consulta> oConsulta = postAgendamentoConsulta.execute(agendamentoConsultaRequestDTO);

        return oConsulta
                .map(ResponseEntity.status(HttpStatus.CREATED)::body)
                .orElseGet(ResponseEntity.status(HttpStatus.BAD_REQUEST)::build);
    }
}
