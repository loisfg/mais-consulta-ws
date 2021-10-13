package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignInRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignUpRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.SignIn;
import com.bandtec.mais.consulta.usecase.auth.Logoff;
import com.bandtec.mais.consulta.usecase.auth.Signup;
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

    private final Signup signup;
    private final SignIn signIn;
    private final Logoff logoff;

    @Autowired
    public AuthController(Signup signup, SignIn signIn, Logoff logoff) {
        this.signup = signup;
        this.signIn = signIn;
        this.logoff = logoff;
        usuariosLogados = new ArrayList<>();
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> signup(@RequestBody UsuarioSignUpRequestDTO usuarioSignUpRequestDTO) {

        Optional<Usuario> oUsuario = signup.execute(usuarioSignUpRequestDTO);

        return oUsuario
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build());

    }

    @PostMapping("/signin")
    public ResponseEntity<Usuario> signin(@RequestBody UsuarioSignInRequestDTO usuarioSignInRequestDTO) {

        Optional<Usuario> oUsuario = signIn.execute(usuarioSignInRequestDTO, usuariosLogados);

        return oUsuario
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.status(HttpStatus.UNAUTHORIZED)::build);
    }

    @PostMapping("/{idUsuario}/logoff")
    public ResponseEntity<?> logoff(@PathVariable Integer idUsuario) {
        return ResponseEntity.of(logoff.execute(idUsuario, usuariosLogados));
    }

}
