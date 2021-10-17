package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medico")
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;

    @Column(name = "nome")
    private String nome;

    @PrimaryKeyJoinColumn(name = "idUbs", referencedColumnName = "idMedico")
    @OneToOne(cascade = CascadeType.ALL)
    private Ubs ubs;

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

    public Ubs getUbs() {
        return ubs;
    }

    public void setUbs(Ubs ubs) {
        this.ubs = ubs;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
