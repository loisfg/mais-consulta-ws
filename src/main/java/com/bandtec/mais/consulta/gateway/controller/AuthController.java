package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.models.dto.request.SignInUserRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.Logoff;
import com.bandtec.mais.consulta.usecase.auth.SignIn;
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

    private final List<User> usuariosLogados;

    @Autowired
    private Logoff logoff;

    @Autowired
    private SignIn signIn;

    @Autowired
    public AuthController() {
        usuariosLogados = new ArrayList<>();
    }

    @PostMapping("/{idUsuario}/logoff")
    public ResponseEntity<?> logoff(@PathVariable Integer idUsuario) {
        return ResponseEntity.of(logoff.execute(idUsuario, usuariosLogados));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInUserRequestDTO signInUserRequestDTO) {

        Optional<?> oUsuario = signIn.execute(signInUserRequestDTO, usuariosLogados);

        return oUsuario
                .map(ResponseEntity::ok)
                    .orElseGet(ResponseEntity.status(HttpStatus.NOT_FOUND)::build);
    }

}
