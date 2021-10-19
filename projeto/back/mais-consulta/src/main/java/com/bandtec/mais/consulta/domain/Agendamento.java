package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agendamento")
@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAgendamento")
    private Integer idAgendamento;

    @Column(name = "dataHr")
    private LocalDate dataHr;

    @Column(name = "dtAtendimento")
    private LocalDate dtAtendimento;

    @Column(name = "especialidade")
    private String especialidade;

    @PrimaryKeyJoinColumn(name = "idUsuario", referencedColumnName = "idAgendamento")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Usuario usuario;

    @PrimaryKeyJoinColumn(name = "idMedico", referencedColumnName = "idAgendamento")
    @OneToOne(cascade = CascadeType.PERSIST)
    protected Medico medico;

    @PrimaryKeyJoinColumn(name = "idPaciente", referencedColumnName = "idAgendamento")
    @OneToOne(cascade = CascadeType.PERSIST)
    protected Paciente paciente;

    @PrimaryKeyJoinColumn(name = "idUbs", referencedColumnName =  "idAgendamento")
    @OneToOne(cascade = CascadeType.PERSIST)
    protected Ubs ubs;

    public Agendamento(LocalDate dtAtendimento, String especialidade) {
        this.dtAtendimento = dtAtendimento;
        this.especialidade = especialidade;
    }

    public Ubs getUbs() {
        return ubs;
    }

    public void setUbs(Ubs ubs) {
        this.ubs = ubs;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Integer getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Integer idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public LocalDate getDataHr() {
        return dataHr;
    }

    public void setDataHr(LocalDate dataHr) {
        this.dataHr = dataHr;
    }

    public LocalDate getDtAtendimento() {
        return dtAtendimento;
    }

    public void setDtAtendimento(LocalDate dtAtendimento) {
        this.dtAtendimento = dtAtendimento;
    }

}
