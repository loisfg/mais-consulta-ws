package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.interfaces.AgendamentoExameResponse;
import com.bandtec.mais.consulta.usecase.schedule.GetAgendamentoExame;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoConsulta;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamentoExame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("agendamento")
public class AgendamentoController {

    private final PostAgendamentoConsulta postAgendamentoConsulta;
    private final PostAgendamentoExame postAgendamentoExame;
    private final GetAgendamentoExame getAgendamentoExame;

    @Autowired
    public AgendamentoController(PostAgendamentoConsulta postAgendamentoConsulta, PostAgendamentoExame postAgendamentoExame, GetAgendamentoExame getAgendamentoExame) {
        this.postAgendamentoConsulta = postAgendamentoConsulta;
        this.postAgendamentoExame = postAgendamentoExame;
        this.getAgendamentoExame = getAgendamentoExame;
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
    public ResponseEntity<?> getExames(@PathVariable Integer idUser) {

        Optional<List<AgendamentoExameResponse>> exame = getAgendamentoExame.execute(idUser);

        if (exame.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(exame);
    }

    @GetMapping("pegar/horas")
    public List<LocalTime> getHours() {
        List<LocalTime> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random gerador = new Random();
            int horas = gerador.nextInt(8);
            int minutos = gerador.nextInt(2);
            LocalTime hora = LocalTime.of(9 + horas, (30 * minutos));

            list.add(hora);
        }

        return list;
    }
}
