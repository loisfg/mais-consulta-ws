package com.bandtec.mais.consulta.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Setter
@Getter
@Table(name = "alergia")
@Entity
public class Alergia {
    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idAlergia;

    private Integer fkUsuario;
}