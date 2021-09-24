package com.bandtec.maisconsulta.usecase.impl

import com.bandtec.maisconsulta.controller.dto.response.UsuarioResponseDTO
import com.bandtec.maisconsulta.controller.dto.request.UsuarioRequestDTO
import com.bandtec.maisconsulta.usecase.Login
import org.springframework.stereotype.Service

@Service
class LoginImpl: Login {
    override fun execute(usuarioRequestDTO: UsuarioRequestDTO): UsuarioResponseDTO {
        TODO("Not yet implemented")
    }
}