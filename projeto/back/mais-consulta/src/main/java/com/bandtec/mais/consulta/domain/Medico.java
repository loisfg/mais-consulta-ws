package com.bandtec.mais.consulta.domain;

import lombok.AccessLevel;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "medico")
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dtNascimento")
    private LocalDate dtNascimento;

    @Column(name = "sexo")
    private String sexo;

    @PrimaryKeyJoinColumn(name = "idEndereco", referencedColumnName = "idMedico")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @Getter(AccessLevel.PROTECTED)
    @PrimaryKeyJoinColumn(name = "idUsuario", referencedColumnName = "idMedico")
    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;

}
