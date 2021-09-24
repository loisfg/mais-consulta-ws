package com.bandtec.maisconsulta.gateway.database.repository

import com.bandtec.maisconsulta.domain.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository("usuarioRepository")
interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByLoginAndPassword(login: String, senha: String): Usuario

}