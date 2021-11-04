package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    private LocalDateTime dhInsert;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dt_atendimento", nullable = false)
    private LocalDate dtAtendimento;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name= "hr_atendimento", nullable = false)
    private LocalTime hrAtendimento;

    @JoinColumn(name = "especialidade_id", referencedColumnName = "id_especialidade", nullable = false)
    @OneToOne(cascade = CascadeType.PERSIST)
    protected Especialidade especialidade;

    @JoinColumn(name = "medico_id", referencedColumnName = "id_medico", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected Medico medico;

    @JoinColumn(name = "paciente_id", referencedColumnName = "id_paciente", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected Paciente paciente;

    @JoinColumn(name = "ubs_id", referencedColumnName = "id_ubs", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected Ubs ubs;
}


