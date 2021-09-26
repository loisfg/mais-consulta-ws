package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.UsuarioRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.UsuarioResponseDTO;
import com.bandtec.mais.consulta.usecase.Login;
import com.bandtec.mais.consulta.usecase.Logoff;
import com.bandtec.mais.consulta.usecase.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final List<Usuario> usuariosLogados;

    private final Signup signup;
    private final Login login;
    private final Logoff logoff;

    @Autowired
    public AuthController(Signup signup, Login login, Logoff logoff) {
        this.signup = signup;
        this.login = login;
        this.logoff = logoff;
        usuariosLogados = new ArrayList<>();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Usuario usuario) {

        Optional<Usuario> oUsuario = signup.execute(usuario);

        if (oUsuario.isPresent()){
            return ResponseEntity.ok(oUsuario.get());
        }else {
            return new ResponseEntity<>("CPF JA CADASTRADO", HttpStatus.BAD_REQUEST);
        }


    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {

        Optional<Usuario> oUsuario = login.execute(usuarioRequestDTO, usuariosLogados);

        return oUsuario
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.status(HttpStatus.UNAUTHORIZED)::build);
    }

    @PostMapping("/logoff")
    public ResponseEntity<String> logoff(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.ok(logoff.execute(usuarioRequestDTO, usuariosLogados));
    }

}
