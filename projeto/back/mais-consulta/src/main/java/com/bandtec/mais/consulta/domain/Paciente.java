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

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "numeroCarteiraSus")
    private String numeroCarteiraSus;

    @PrimaryKeyJoinColumn(name = "idEndereco", referencedColumnName = "idPaciente")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @PrimaryKeyJoinColumn(name = "idUsuario", referencedColumnName = "idPaciente")
    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;


    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getNumeroCarteiraSus() {
        return numeroCarteiraSus;
    }

    public void setNumeroCarteiraSus(String numeroCarteiraSus) {
        this.numeroCarteiraSus = numeroCarteiraSus;
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
