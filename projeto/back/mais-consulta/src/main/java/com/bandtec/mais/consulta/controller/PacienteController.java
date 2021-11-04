package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.PacienteSignUpRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignInRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.PacienteSignInResponseDTO;
import com.bandtec.mais.consulta.usecase.auth.PacienteSignup;
import com.bandtec.mais.consulta.usecase.auth.PacienteSignIn;
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
    private PacienteSignIn pacienteSignIn;

    @PostMapping("/signin")
    public ResponseEntity<PacienteSignInResponseDTO> signin(@RequestBody UsuarioSignInRequestDTO usuarioSignInRequestDTO) {

        Optional<PacienteSignInResponseDTO> oUsuario = pacienteSignIn.execute(usuarioSignInRequestDTO, usuariosLogados);

        return oUsuario
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.status(HttpStatus.UNAUTHORIZED)::build);
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> pacienteSignUp(@RequestBody PacienteSignUpRequestDTO pacienteSignUpRequestDTO) {

        Optional<Usuario> oUsuario = pacienteSignup.execute(pacienteSignUpRequestDTO);

        return oUsuario
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}
