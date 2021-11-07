package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "usuario", indexes = {
        @Index(name = "idx_usuario_cpf", columnList = "cpf"),
        @Index(name = "idx_usuario_password", columnList = "password")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @CPF
    @Column(nullable = false)
    private String cpf;

    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    private String role;

}
