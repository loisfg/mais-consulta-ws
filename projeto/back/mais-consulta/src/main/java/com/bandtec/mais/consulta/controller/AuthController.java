package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.usecase.auth.Logoff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("auth")
public class AuthController {

    private final List<Usuario> usuariosLogados;

    @Autowired
    private Logoff logoff;

    @Autowired
    public AuthController() {
        usuariosLogados = new ArrayList<>();
    }

    @PostMapping("/{idUsuario}/logoff")
    public ResponseEntity<?> logoff(@PathVariable Integer idUsuario) {
        return ResponseEntity.of(logoff.execute(idUsuario, usuariosLogados));
    }

}
