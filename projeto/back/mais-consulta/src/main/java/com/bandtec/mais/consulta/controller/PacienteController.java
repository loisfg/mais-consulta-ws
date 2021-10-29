package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.PacienteSignUpRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.PacienteSignup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("paciente")
public class PacienteController {

    private final PacienteSignup pacienteSignup;

    @Autowired
    public PacienteController(PacienteSignup pacienteSignup) {
        this.pacienteSignup = pacienteSignup;
    }


    @PostMapping("/paciente/signup")
    public ResponseEntity<Usuario> pacienteSignUp(@RequestBody PacienteSignUpRequestDTO pacienteSignUpRequestDTO) {

        Optional<Usuario> oUsuario = pacienteSignup.execute(pacienteSignUpRequestDTO);

        return oUsuario
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}
