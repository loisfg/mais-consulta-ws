package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendaMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dt_atendimento", nullable = false)
    private LocalDate dtAtendimento;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name= "hr_atendimento", nullable = false)
    private LocalTime hrAtendimento;

    @OneToOne
    private Medico medico;

    @OneToOne
    Agendamento agendamento;
}
