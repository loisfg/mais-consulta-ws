package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.MedicoSignUpRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignInRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.PacienteSignUpRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.MedicoSignUp;
import com.bandtec.mais.consulta.usecase.auth.PacienteSignIn;
import com.bandtec.mais.consulta.usecase.auth.Logoff;
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
@RequestMapping("auth")
public class AuthController {

    private final List<Usuario> usuariosLogados;

    private final MedicoSignUp medicoSignup;

    private final PacienteSignup pacienteSignup;
    private final PacienteSignIn pacienteSignIn;
    private final Logoff logoff;

    @Autowired
    public AuthController(MedicoSignUp medicoSignup, PacienteSignup pacienteSignup, PacienteSignIn pacienteSignIn, Logoff logoff) {
        this.medicoSignup = medicoSignup;
        this.pacienteSignup = pacienteSignup;
        this.pacienteSignIn = pacienteSignIn;
        this.logoff = logoff;
        usuariosLogados = new ArrayList<>();
    }

    @PostMapping("/paciente/signup")
    public ResponseEntity<Usuario> pacienteSignUp(@RequestBody PacienteSignUpRequestDTO pacienteSignUpRequestDTO) {

        Optional<Usuario> oUsuario = pacienteSignup.execute(pacienteSignUpRequestDTO);

        return oUsuario
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build());

    }

    @PostMapping("/medico/signup")
    public ResponseEntity<Usuario> medicoSignUp(@RequestBody MedicoSignUpRequestDTO medicoSignUpRequestDTO) {

        Optional<Usuario> oUsuario = medicoSignup.execute(medicoSignUpRequestDTO);

        return oUsuario
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build());

    }

    @PostMapping("/signin")
    public ResponseEntity<Usuario> signin(@RequestBody UsuarioSignInRequestDTO usuarioSignInRequestDTO) {

        Optional<Usuario> oUsuario = pacienteSignIn.execute(usuarioSignInRequestDTO, usuariosLogados);

        return oUsuario
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.status(HttpStatus.UNAUTHORIZED)::build);
    }

    @PostMapping("/{idUsuario}/logoff")
    public ResponseEntity<?> logoff(@PathVariable Integer idUsuario) {
        return ResponseEntity.of(logoff.execute(idUsuario, usuariosLogados));
    }

}
