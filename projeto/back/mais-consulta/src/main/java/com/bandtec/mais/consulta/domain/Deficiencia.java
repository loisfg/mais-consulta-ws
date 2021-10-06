package com.bandtec.mais.consulta.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Table(name = "deficiencia")
@Entity
public class Deficiencia {
    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer idDeficiencia;

    private Integer fkUsuario;
}