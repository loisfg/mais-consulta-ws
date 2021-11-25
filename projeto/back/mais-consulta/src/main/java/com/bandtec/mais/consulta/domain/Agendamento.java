package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

    @Future
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dt_atendimento", nullable = false)
    private LocalDate dtAtendimento;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name= "hr_atendimento", nullable = false)
    private LocalTime hrAtendimento;

    // TODO criar enum com os tipos: REALIZADO, CANCELADO, ATIVO
    private String status;

    @JoinColumn(name = "especialidade_id", referencedColumnName = "id_especialidade", nullable = false)
    @OneToOne
    private Especialidade especialidade;

    @JoinColumn(name = "paciente_id", referencedColumnName = "id_paciente", nullable = false)
    @OneToOne
    private Paciente paciente;

    @JoinColumn(name = "medico_id", referencedColumnName = "id_medico", nullable = false)
    @OneToOne
    private Medico medico;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Agendamento that = (Agendamento) o;

        return Objects.equals(idAgendamento, that.idAgendamento);
    }

    @Override
    public int hashCode() {
        return 1317206274;
    }
}


