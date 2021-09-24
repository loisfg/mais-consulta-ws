package com.bandtec.maisconsulta.usecase

import com.bandtec.maisconsulta.controller.dto.request.UsuarioRequestDTO

interface Logoff {
    fun execute(usuarioRequestDTO: UsuarioRequestDTO): Void
}