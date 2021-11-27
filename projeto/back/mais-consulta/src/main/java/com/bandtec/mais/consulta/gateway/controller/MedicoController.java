package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.MedicoSignUpRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.PacienteInfoRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.MedicoAgendamentoDTO;
import com.bandtec.mais.consulta.models.dto.response.MedicoHistoricoResponseDTO;
import com.bandtec.mais.consulta.usecase.auth.MedicoDelete;
import com.bandtec.mais.consulta.usecase.auth.MedicoSignUp;
import com.bandtec.mais.consulta.usecase.doctor.MedicoHistorico;
import com.bandtec.mais.consulta.usecase.doctor.PostFormularioAtendimento;
import com.bandtec.mais.consulta.usecase.doctor.MedicoAgendamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoSignUp medicoSignup;

    @Autowired
    private MedicoDelete medicoDelete;

    @Autowired
    private MedicoAgendamentos medicoAgendamentos;

    @Autowired
    private MedicoHistorico medicoHistorico;

    @Autowired
    private PostFormularioAtendimento postFormularioAtendimento;

    @PostMapping("{idMedico}/{idPaciente}/atendimento")
    public ResponseEntity<?> editarFormularioAtendimento(@PathVariable Integer idMedico,
                                                         @PathVariable Integer idPaciente,
                                                         @RequestBody PacienteInfoRequestDTO pacienteInfoRequestDTO) {
        return ResponseEntity.of(postFormularioAtendimento.execute(idMedico, idPaciente, pacienteInfoRequestDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> medicoSignUp(@RequestBody MedicoSignUpRequestDTO medicoSignUpRequestDTO) {

        Optional<Usuario> oUsuario = medicoSignup.execute(medicoSignUpRequestDTO);

        return oUsuario
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> medicoDelete(@PathVariable Integer id) {
        if (medicoDelete.execute(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{idMedico}/agendamentos")
    public ResponseEntity<List<MedicoAgendamentoDTO>> getAgendamentosByMedico(@PathVariable Integer idMedico) {
        Optional<List<MedicoAgendamentoDTO>> oAgendamentos = medicoAgendamentos.execute(idMedico);

        return oAgendamentos
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/{idMedico}/historico")
    public ResponseEntity<List<MedicoHistoricoResponseDTO>> getHistoricoByMedico(@PathVariable Integer idMedico) {
        Optional<List<MedicoHistoricoResponseDTO>> oHistorico = medicoHistorico.execute(idMedico);

        return oHistorico
                .map(it -> ResponseEntity.status(HttpStatus.OK).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

}
