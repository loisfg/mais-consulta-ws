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

    private final List<User> connectedUsers;

    @Autowired
    private Logoff logoff;

    @Autowired
    private SignIn signIn;

    @Autowired
    public AuthController() {
        connectedUsers = new ArrayList<>();
    }

    @PostMapping("/{userId}/logoff")
    public ResponseEntity<?> logoff(@PathVariable Integer userId) {
        return ResponseEntity.of(logoff.execute(userId, connectedUsers));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInUserRequestDTO signInUserRequestDTO) {

        Optional<?> oUser = signIn.execute(signInUserRequestDTO, connectedUsers);

        return oUser
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.status(HttpStatus.NOT_FOUND)::build);
    }

}
