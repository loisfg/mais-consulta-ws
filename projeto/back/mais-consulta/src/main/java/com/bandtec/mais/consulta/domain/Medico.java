package com.bandtec.mais.consulta.domain;

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

    @Column(name = "especialidade")
    private String especialidade;

    @PrimaryKeyJoinColumn(name = "idEndereco", referencedColumnName = "idMedico")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @PrimaryKeyJoinColumn(name = "idUsuario", referencedColumnName = "idMedico")
    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;

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

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
