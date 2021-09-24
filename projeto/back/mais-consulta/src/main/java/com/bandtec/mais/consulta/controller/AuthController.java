package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.controller.dto.request.UsuarioRequestDTO;
import com.bandtec.mais.consulta.controller.dto.response.UsuarioResponseDTO;
import com.bandtec.mais.consulta.usecase.Login;
import com.bandtec.mais.consulta.usecase.Logoff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private final Login login;

    @Autowired
    private final Logoff logoff;

    public AuthController(Login login, Logoff logoff) {
        this.login = login;
        this.logoff = logoff;
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        return ResponseEntity.ok(login.execute(usuarioRequestDTO));
    }

    @PostMapping("/logoff")
    public ResponseEntity<Void> logoff(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        return ResponseEntity.ok(logoff.execute(usuarioRequestDTO));
    }

}
