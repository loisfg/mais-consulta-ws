package com.bandtec.mais.consulta.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Table(name = "remedios")
@Entity
public class Remedio {
    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "", nullable = false)
    private Integer idRemedio;

    private Integer fkUsuario;
}