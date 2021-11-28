package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.PacienteSignUpRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.PacienteAgendamentosResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PacienteHistoricoResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PacienteInfoResponseDTO;
import com.bandtec.mais.consulta.usecase.patient.GetAgenda;
import com.bandtec.mais.consulta.usecase.patient.GetHistorico;
import com.bandtec.mais.consulta.usecase.patient.GetPacienteInfo;
import com.bandtec.mais.consulta.usecase.auth.PacienteSignup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("paciente")
public class PacienteController {

    private final List<Usuario> usuariosLogados;

    public PacienteController() {
        this.usuariosLogados = new ArrayList<>();
    }

    @Autowired
    private PacienteSignup pacienteSignup;

    @Autowired
    private GetAgenda getAgenda;

    @Autowired
    private GetPacienteInfo getPacienteInfo;

    @Autowired
    private GetHistorico getHistorico;

    @GetMapping("{idPaciente}")
    public ResponseEntity<PacienteInfoResponseDTO> getPacienteInfo(@PathVariable Integer idPaciente){
        return ResponseEntity.of(getPacienteInfo.execute(idPaciente));
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> pacienteSignUp(@RequestBody PacienteSignUpRequestDTO pacienteSignUpRequestDTO) {

        Optional<Usuario> oUsuario = pacienteSignup.execute(pacienteSignUpRequestDTO);

        return oUsuario
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping("/agenda/{idPaciente}/{dtStart}/{dtEnd}")
    public ResponseEntity<List<PacienteAgendamentosResponseDTO>> getAgendaPaciente(@PathVariable Integer idPaciente,
                                                                                   @PathVariable String dtStart,
                                                                                   @PathVariable String dtEnd) {
        Optional<List<PacienteAgendamentosResponseDTO>> oAgenda = getAgenda.execute(idPaciente, dtStart, dtEnd);

        return oAgenda
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/historico/{idPaciente}")
    public ResponseEntity<List<PacienteHistoricoResponseDTO>> getHistoricoPaciente(@PathVariable Integer idPaciente) {

        Optional<List<PacienteHistoricoResponseDTO>> oHistorico = getHistorico.execute(idPaciente);

        return oHistorico
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }
}
