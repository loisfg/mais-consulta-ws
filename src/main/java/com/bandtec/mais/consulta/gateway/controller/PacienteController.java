package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.models.dto.request.PatientInfoPutRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.SignUpPatientRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientSchedulingResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientHistoricResponseDTO;
import com.bandtec.mais.consulta.models.dto.response.PatientInfoResponseDTO;
import com.bandtec.mais.consulta.usecase.auth.PacienteSignup;
import com.bandtec.mais.consulta.usecase.patient.GetAgenda;
import com.bandtec.mais.consulta.usecase.patient.GetHistorico;
import com.bandtec.mais.consulta.usecase.patient.GetPacienteInfo;
import com.bandtec.mais.consulta.usecase.patient.PutPacienteInfo;
import com.bandtec.mais.consulta.usecase.ubs.GetUbs;
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

    private final List<User> usuariosLogados;

    public PacienteController() {
        this.usuariosLogados = new ArrayList<>();
    }

    @Autowired
    private GetUbs getUbs;

    @Autowired
    private PacienteSignup pacienteSignup;

    @Autowired
    private GetAgenda getAgenda;

    @Autowired
    private GetPacienteInfo getPacienteInfo;

    @Autowired
    private GetHistorico getHistorico;

    @Autowired
    private PutPacienteInfo putPacienteInfo;

    @GetMapping("/{idPaciente}")
    public ResponseEntity<PatientInfoResponseDTO> getPacienteInfo(@PathVariable Integer idPaciente){
        return ResponseEntity.of(getPacienteInfo.execute(idPaciente));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> pacienteSignUp(@RequestBody SignUpPatientRequestDTO signUpPatientRequestDTO) {

        Optional<User> oUsuario = pacienteSignup.execute(signUpPatientRequestDTO);

        return oUsuario
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping("/agenda/{idPaciente}")
    public ResponseEntity<List<PatientSchedulingResponseDTO>> getAgendaPaciente(@PathVariable Integer idPaciente,
                                                                                @RequestHeader(value="dtStart") String dataInicio,
                                                                                @RequestHeader(value="dtEnd") String dataFim
                                                                                   ) {
        Optional<List<PatientSchedulingResponseDTO>> oAgenda = getAgenda.execute(idPaciente, dataInicio,dataFim);

        return oAgenda
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/historico/{idPaciente}")
    public ResponseEntity<List<PatientHistoricResponseDTO>> getHistoricoPaciente(@PathVariable Integer idPaciente) {

        Optional<List<PatientHistoricResponseDTO>> oHistorico = getHistorico.execute(idPaciente);

        return oHistorico
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/mapa/{idPaciente}")
    public ResponseEntity<List<Ubs>> getUbsByLocalizacao(@PathVariable Integer idPaciente) {
        return ResponseEntity.of(getUbs.execute(idPaciente));
    }

    @PutMapping("{idPaciente}")
    public ResponseEntity<Patient> putInfosPaciente(@PathVariable Integer idPaciente,
                                                    @RequestBody PatientInfoPutRequestDTO patientInfoPutRequestDTO) {
        ResponseEntity.of(putPacienteInfo.execute(idPaciente, patientInfoPutRequestDTO));

        return null;
    }
}
