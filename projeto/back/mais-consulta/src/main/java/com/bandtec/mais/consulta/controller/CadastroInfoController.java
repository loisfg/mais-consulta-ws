package com.bandtec.mais.consulta.controller;

import com.bandtec.mais.consulta.domain.InfoCadastro;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.models.dto.request.UsuarioRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("info")
public class CadastroInfoController {

    @Id
    private Integer Id;
    private InfoCadastro infoCadastro;

    @PostMapping("/infocadastro")
    public InfoCadastro getCadastro(@RequestBody InfoCadastro info){
        return info;
    }


//    public ResponseEntity<Usuario> login(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
//
//        Optional<Usuario> oUsuario = login.execute(usuarioRequestDTO, usuariosLogados);
//
//        return oUsuario
//                .map(ResponseEntity::ok)
//                .orElseGet(ResponseEntity.status(HttpStatus.UNAUTHORIZED)::build);
//    }
}
