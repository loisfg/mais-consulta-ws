package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.MedicoSignUpRequestDTO;
import com.bandtec.mais.consulta.models.dto.request.UsuarioSignInRequestDTO;
import com.bandtec.mais.consulta.models.dto.response.MedicoSignInResponseDTO;
import com.bandtec.mais.consulta.usecase.auth.MedicoDelete;
import com.bandtec.mais.consulta.usecase.auth.MedicoSignIn;
import com.bandtec.mais.consulta.usecase.auth.MedicoSignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("medico")
public class MedicoController {

    private final List<Usuario> usuariosLogados;

    @Autowired
    public MedicoController() {
        usuariosLogados = new ArrayList<>();
    }

    @Autowired
    private MedicoSignUp medicoSignup;

    @Autowired
    private MedicoDelete medicoDelete;

    @Autowired
    private MedicoSignIn medicoSignIn;

    @PostMapping("/signin")
    public ResponseEntity<MedicoSignInResponseDTO> signin(@RequestBody UsuarioSignInRequestDTO usuarioSignInRequestDTO) {

        Optional<MedicoSignInResponseDTO> oUsuario = medicoSignIn.execute(usuarioSignInRequestDTO, usuariosLogados);

        return oUsuario
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.status(HttpStatus.UNAUTHORIZED)::build);
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> medicoSignUp(@RequestBody MedicoSignUpRequestDTO medicoSignUpRequestDTO) {

        Optional<Usuario> oUsuario = medicoSignup.execute(medicoSignUpRequestDTO);

        return oUsuario
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> medicoDelete(@PathVariable Integer id) {
        if (medicoDelete.execute(id)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
