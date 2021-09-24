package com.bandtec.maisconsulta.controller.dto.request

import javax.persistence.Column

data class UsuarioRequestDTO(
    var login: String,
    var password: String
)
