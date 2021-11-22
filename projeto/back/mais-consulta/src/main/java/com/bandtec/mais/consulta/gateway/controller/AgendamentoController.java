package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoConsultaRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.AgendamentoExameRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.AgendamentoConsultaResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.AgendamentoExameResponseDTO;
import com.bandtec.mais.consulta.usecase.schedule.*;
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

    @GetMapping("/testeMedico")
    public Optional<List<Integer>> recebermedico() {
        return medicoRepository.findIdsMedicosByIdEspecialidade(1);
    }

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

//    @GetMapping
//    public ResponseEntity<List<?>> getAvaibleTime(@RequestBody) {
//
//    }

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

/*
    Precisamos fazer duas tabelas auxiliares
    uma com dias e outra com horarios
    os dia+horario que o medico ja tem atendimento
    sera setado dentro dele, assim esses valores
    ficaram "desligados" no front para serem selecionados.

    verifica todos os medicos de uma especialidade daquela ubs
    e se não existir medicos disponiveis para aquele dia+hora
    deixa a opção "desligada"  no front.
*/
