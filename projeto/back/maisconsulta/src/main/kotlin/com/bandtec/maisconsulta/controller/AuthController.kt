package com.bandtec.maisconsulta.controller

import com.bandtec.maisconsulta.controller.dto.response.UsuarioResponseDTO
import com.bandtec.maisconsulta.controller.dto.request.UsuarioRequestDTO
import com.bandtec.maisconsulta.usecase.Login
import com.bandtec.maisconsulta.usecase.Logoff
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth")
class AuthController @Autowired constructor(
    private var logoff: Logoff,
    private var login: Login
) {

    @PostMapping("/login")
    fun login(@RequestBody usuarioRequestDTO: UsuarioRequestDTO): ResponseEntity<UsuarioResponseDTO> {
        return ResponseEntity.ok(login.execute(usuarioRequestDTO))
    }

    @PostMapping("/logoff")
    fun logoff(@RequestBody usuarioRequestDTO: UsuarioRequestDTO): ResponseEntity<Void> {
        return ResponseEntity.ok(logoff.execute(usuarioRequestDTO))
    }

}