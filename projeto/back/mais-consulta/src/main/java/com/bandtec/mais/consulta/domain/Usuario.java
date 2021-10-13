package com.bandtec.mais.consulta.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    protected String password;

    @Column(name = "telefone")
    private String telefone;

    @OneToOne(mappedBy = "usuario")
    private Paciente paciente;

    public String pegarSenha(){
        return password;
    }

    public String getCpf() {
        return cpf;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
