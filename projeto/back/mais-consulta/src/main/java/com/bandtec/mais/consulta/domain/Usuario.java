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

    public Usuario(String cpf, String email, String password) {
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public String pegarSenha(){
        return password;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
