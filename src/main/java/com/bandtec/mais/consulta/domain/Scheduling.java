package com.bandtec.mais.consulta.domain;

import com.bandtec.mais.consulta.models.enums.SchedulingStatusEnum;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
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
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agendamento")
    private Integer schedulingId;

    @Column(name = "data_hr")
    @Temporal(TemporalType.DATE)
    private Date insertDateTime;

    @FutureOrPresent(message = "Data passada deve ser uma data futura")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dt_atendimento", nullable = false)
    private LocalDate schedulingDate;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "hr_atendimento", nullable = false)
    private LocalTime schedulingTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SchedulingStatusEnum status;

    @JoinColumn(name = "especialidade_id", referencedColumnName = "id_especialidade", nullable = false)
    @OneToOne
    private Specialty specialty;


    @JoinColumn(name = "paciente_id", referencedColumnName = "id_paciente", nullable = false)
    @OneToOne(fetch = FetchType.EAGER)
    private Patient patient;

    @JoinColumn(name = "medico_id", referencedColumnName = "id_medico", nullable = false)
    @OneToOne
    private Doctor doctor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Scheduling that = (Scheduling) o;

        return Objects.equals(schedulingId, that.schedulingId);
    }

    @Override
    public int hashCode() {
        return 1317206274;
    }
}


