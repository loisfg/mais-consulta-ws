package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;
import org.hibernate.type.TimeType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "Agendamento", schema = "dbo", catalog = "maisconsultadb")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agendamento")
    private Integer idAgendamento;

    @Column(name = "data_hr")
    @Temporal(TemporalType.DATE)
    private Date dhInsert;

    @FutureOrPresent(message = "Data passada deve ser uma data futura")
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
    @OneToOne(fetch = FetchType.EAGER)
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


