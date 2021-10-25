package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
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
    private String password;

    protected Usuario() {}

    public Usuario(String cpf, String email, String password) {
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public static UsuarioEntityBuilder builder(){
        return new UsuarioEntityBuilder();
    }

    public static class UsuarioEntityBuilder {
        private String cpf;
        private String email;
        protected String password;

        public UsuarioEntityBuilder setCpf(final String cpf) {
            this.cpf = cpf;
            return this;
        }

        public UsuarioEntityBuilder setEmail(final String email) {
            this.email = email;
            return this;
        }

        public UsuarioEntityBuilder setPassword(final String password) {
            this.password = password;
            return this;
        }

        public Usuario build() {
            return new Usuario(cpf, email, password);
        }

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
