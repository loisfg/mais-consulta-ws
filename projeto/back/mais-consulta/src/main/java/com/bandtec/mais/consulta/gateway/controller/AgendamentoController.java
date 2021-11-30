package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.gateway.repository.EspecialidadeRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.UbsRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.AgendamentoResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.EspecialidadeResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.*;
import com.bandtec.mais.consulta.usecase.ubs.PostHoursUbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@CrossOrigin("*")
@RestController
@RequestMapping("agendamento")
public class AgendamentoController {

    @Autowired
    private PostAgendamentoConsulta postAgendamentoConsulta;

    @Autowired
    private PostAgendamentoExame postAgendamentoExame;

    @Autowired
    private GetAgendamentoExame getAgendamentoExame;

    @Autowired
    private GetAgendamentoConsulta getAgendamentoConsulta;

    @Autowired
    private CancelAgendamento cancelAgendamento;

    @Autowired
    private PostHoursUbs postHoursUbs;

    @Autowired
    private GetEspecialidades getEspecialidades;

    private static final String EXTERNAL_FILE_PATH = "mais-consulta/";
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

    @GetMapping("/exames/{idUser}")
    public ResponseEntity<?> getExamesByIdUser(@PathVariable Integer idUser) {

        Optional<List<AgendamentoResponseDTO>> oListExames = getAgendamentoExame.execute(idUser);

        return oListExames
                .map(ResponseEntity.status(HttpStatus.OK)::body)
                .orElseGet(ResponseEntity.status(HttpStatus.NO_CONTENT)::build);
    }

    @GetMapping("/consulta/{idUser}")
    public ResponseEntity<?> getConsultaByIdUser(@PathVariable Integer idUser) {

        Optional<List<AgendamentoResponseDTO>> oListConsultas = getAgendamentoConsulta.execute(idUser);

        return oListConsultas
                .map(ResponseEntity.status(HttpStatus.OK)::body)
                .orElseGet(ResponseEntity.status(HttpStatus.NO_CONTENT)::build);
    }

    @GetMapping("/horarios/livres/{dia}/{idUbs}")
    public ResponseEntity<List<LocalTime>> getAvaibleTime(@PathVariable Integer idUbs,
                                                          @PathVariable String dia) {
        List<LocalTime> listHoras = postHoursUbs.execute(idUbs, dia);
        if(listHoras.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(listHoras);
    }

    @GetMapping("/especialidades")
    public ResponseEntity<Set<EspecialidadeResponseDTO>> getEspecialidades() {

        return ResponseEntity.of(getEspecialidades.execute());

    }
}
