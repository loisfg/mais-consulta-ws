package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignInRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.Logoff;
import com.bandtec.mais.consulta.usecase.auth.UsuarioSignIn;
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

    private final UsuarioSignIn usuarioSignIn;
    private final Logoff logoff;

    @Autowired
    public AuthController(UsuarioSignIn usuarioSignIn, Logoff logoff) {
        this.usuarioSignIn = usuarioSignIn;
        this.logoff = logoff;
        usuariosLogados = new ArrayList<>();
    }



    @PostMapping("/signin")
    public ResponseEntity<Usuario> signin(@RequestBody UsuarioSignInRequestDTO usuarioSignInRequestDTO) {

        Optional<Usuario> oUsuario = usuarioSignIn.execute(usuarioSignInRequestDTO, usuariosLogados);

        return oUsuario
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.status(HttpStatus.UNAUTHORIZED)::build);
    }

    @PostMapping("/{idUsuario}/logoff")
    public ResponseEntity<?> logoff(@PathVariable Integer idUsuario) {
        return ResponseEntity.of(logoff.execute(idUsuario, usuariosLogados));
    }

}
