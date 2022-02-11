package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoConsulta;
import com.bandtec.mais.consulta.infra.queue.FilaAgendamentoExame;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fila")
public class EsperaAgendamentoControllerTest {

    @Autowired
    private FilaAgendamentoConsulta filaAgendamentoConsulta;

    @Autowired
    private FilaAgendamentoExame filaAgendamentoExame;

    @PostMapping("consulta")
    public ResponseEntity<?> esperar(@RequestBody AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO){

        filaAgendamentoConsulta.setFilaAgendamentoConsulta(agendamentoConsultaRequestDTO);

        return null;
    }

    @PostMapping("exame")
    public ResponseEntity<?> esperar(@RequestBody AgendamentoExameRequestDTO agendamentoExameRequestDTO){

        filaAgendamentoExame.setFilaAgendamentoExame(agendamentoExameRequestDTO);

        return null;
    }

}
