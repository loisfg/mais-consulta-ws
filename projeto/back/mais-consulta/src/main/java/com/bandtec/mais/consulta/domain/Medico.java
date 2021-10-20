package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "medico")
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;

    @Column(name = "nome")
    private String nome;

    @PrimaryKeyJoinColumn(name = "idUsuario", referencedColumnName = "idMedico")
    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;

    @PrimaryKeyJoinColumn(name = "idEspecialidade", referencedColumnName = "idMedico")
    @OneToOne(cascade = CascadeType.ALL)
    protected Especialidade especialidade;

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
