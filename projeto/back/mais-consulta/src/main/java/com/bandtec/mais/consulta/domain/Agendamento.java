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
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @PrimaryKeyJoinColumn(name = "idMedico", referencedColumnName = "idAgendamento")
    @OneToOne(cascade = CascadeType.ALL)
    protected Medico medico;

    @PrimaryKeyJoinColumn(name = "idUbs", referencedColumnName = "idAgendamento")
    @OneToOne(cascade = CascadeType.ALL)
    protected Ubs ubs;

    @PrimaryKeyJoinColumn(name = "idPaciente", referencedColumnName = "idAgendamento")
    @OneToOne(cascade = CascadeType.ALL)
    protected Paciente paciente;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}
