package com.bandtec.mais.consulta.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente")
    private Integer idPaciente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dtNascimento")
    private LocalDate dtNascimento;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "numeroCarteiraSus")
    private String numeroCarteiraSus;

    @PrimaryKeyJoinColumn(name = "idEndereco", referencedColumnName = "idPaciente")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @Getter(AccessLevel.PROTECTED)
    @PrimaryKeyJoinColumn(name = "idUsuario", referencedColumnName = "idPaciente")
    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;

}
