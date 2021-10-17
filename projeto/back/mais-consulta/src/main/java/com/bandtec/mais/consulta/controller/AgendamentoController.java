package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoRequestDTO;
import com.bandtec.mais.consulta.usecase.schedule.PostAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("agendamento")
public class AgendamentoController {

    private final PostAgendamento postAgendamento;

    @Autowired
    public AgendamentoController(PostAgendamento postAgendamento) {
        this.postAgendamento = postAgendamento;
    }

    @PostMapping("agendar")
    public ResponseEntity<Agendamento> createAgendamento(@RequestBody AgendamentoRequestDTO agendamentoRequestDTO) {
        Optional<Agendamento> oAgendamento = Optional.ofNullable(postAgendamento.execute(agendamentoRequestDTO));

        return oAgendamento
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build());
    }
}
