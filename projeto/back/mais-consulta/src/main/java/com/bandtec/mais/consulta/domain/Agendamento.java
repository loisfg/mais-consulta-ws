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
    @Column(name = "id_agendamento")
    private Integer idAgendamento;

    @Column(name = "data_hr")
    private LocalDate dataHr;

    @Column(name = "dt_atendimento")
    private LocalDate dtAtendimento;

    @PrimaryKeyJoinColumn(name = "id_especialidade", referencedColumnName = "id_agendamento")
    @OneToOne(cascade = CascadeType.ALL)
    protected Especialidade especialidade;

    @PrimaryKeyJoinColumn(name = "id_usuario", referencedColumnName = "id_agendamento")
    @OneToOne(cascade = CascadeType.PERSIST)
    private Usuario usuario;

    @PrimaryKeyJoinColumn(name = "id_medico", referencedColumnName = "id_agendamento")
    @OneToOne(cascade = CascadeType.PERSIST)
    protected Medico medico;

    @PrimaryKeyJoinColumn(name = "id_paciente", referencedColumnName = "id_agendamento")
    @OneToOne(cascade = CascadeType.PERSIST)
    protected Paciente paciente;

    @PrimaryKeyJoinColumn(name = "id_ubs", referencedColumnName =  "id_agendamento")
    @OneToOne(cascade = CascadeType.PERSIST)
    protected Ubs ubs;

    public Ubs getUbs() {
        return ubs;
    }

    public void setUbs(Ubs ubs) {
        this.ubs = ubs;
    }

    public void setEspecialidade(Especialidade especialidade) {
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

    public Especialidade getEspecialidade() {
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
