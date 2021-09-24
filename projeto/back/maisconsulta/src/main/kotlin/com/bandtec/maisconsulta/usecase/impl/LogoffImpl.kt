package com.bandtec.maisconsulta.usecase.impl

import com.bandtec.maisconsulta.controller.dto.request.UsuarioRequestDTO
import com.bandtec.maisconsulta.usecase.Logoff
import org.springframework.stereotype.Service

@Service
class LogoffImpl: Logoff {
    override fun execute(usuarioRequestDTO: UsuarioRequestDTO): Void {
        TODO("Not yet implemented")
    }
}