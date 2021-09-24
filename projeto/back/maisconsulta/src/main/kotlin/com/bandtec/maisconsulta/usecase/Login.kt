package com.bandtec.maisconsulta.usecase

import com.bandtec.maisconsulta.controller.dto.response.UsuarioResponseDTO
import com.bandtec.maisconsulta.controller.dto.request.UsuarioRequestDTO

interface Login {
    fun execute(usuarioRequestDTO: UsuarioRequestDTO): UsuarioResponseDTO
}