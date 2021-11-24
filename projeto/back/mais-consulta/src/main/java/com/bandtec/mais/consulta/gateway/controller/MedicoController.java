package com.bandtec.mais.consulta.gateway.controller;

import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.MedicoSignUpRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.MedicoDelete;
import com.bandtec.mais.consulta.usecase.auth.MedicoSignUp;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoSignUp medicoSignup;

    @Autowired
    private MedicoDelete medicoDelete;

//    @Autowired
//    private ;

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

//    @GetMapping("/{idMedico}/agendamentos")
//    public ResponseEntity<?> getAgendamentosByMedico(@PathVariable Integer idMedico) {
//
//    }

}

/*
GET {{url}}/medico/{doctorId}/agendamentos HTTP/1.1
# Retorno esperado
# [
    # {
        # id: number, (esse e o id do paciente)
        # name: string,
        # age: number,
        # scheduleTime: time
    # }
# ]
 */