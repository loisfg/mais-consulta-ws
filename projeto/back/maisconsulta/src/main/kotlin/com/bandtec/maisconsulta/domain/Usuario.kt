package com.bandtec.maisconsulta.domain

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "usuario")
data class Usuario(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    var idUsuario: Long? = null,

    @Column(name = "login")
    val login: String? = null,

    @Column(name = "password")
    var password: String? = null

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Usuario

        return idUsuario != null && idUsuario == other.idUsuario
    }

    override fun hashCode(): Int = 0

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idUsuario = $idUsuario , login = $login , password = $password )"
    }
}




