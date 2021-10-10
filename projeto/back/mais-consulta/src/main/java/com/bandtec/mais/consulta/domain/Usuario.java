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

    @OneToMany(mappedBy="usuario",fetch = FetchType.LAZY)
    private Set<Alergia> alergia;

    @OneToMany(mappedBy= "usuario", fetch = FetchType.LAZY)
    private Set<Doenca> doenca;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Remedio> remedio;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Deficiencia> deficiencia;

    public Usuario() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Set<Alergia> getAlergia() {
        return alergia;
    }

    public void setAlergia(Set<Alergia> alergia) {
        this.alergia = alergia;
    }

    public Set<Doenca> getDoenca() {
        return doenca;
    }

    public void setDoenca(Set<Doenca> doenca) {
        this.doenca = doenca;
    }

    public Set<Remedio> getRemedio() {
        return remedio;
    }

    public void setRemedio(Set<Remedio> remedio) {
        this.remedio = remedio;
    }

    public Set<Deficiencia> getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(Set<Deficiencia> deficiencia) {
        this.deficiencia = deficiencia;
    }
}
