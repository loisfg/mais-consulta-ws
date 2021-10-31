package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agendamento")
    private Integer idAgendamento;

    @Column(name = "data_hr")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataHr;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dt_atendimento", nullable = false)
    private LocalDate dtAtendimento;

    @Column(name= "hr_atendimento", nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalDate hrAtendimento;

    @PrimaryKeyJoinColumn(name = "id_especialidade", referencedColumnName = "id_agendamento")
    @OneToOne(cascade = CascadeType.PERSIST)
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
}


