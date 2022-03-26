package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "Exame", schema = "dbo", catalog = "maisconsultadb")
@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exame", nullable = false)
    private Integer examId;

    private String description;

    @JoinColumn(name = "agendamento_id", referencedColumnName = "id_agendamento", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected Scheduling scheduling;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Exam exam = (Exam) o;

        return Objects.equals(examId, exam.examId);
    }

    @Override
    public int hashCode() {
        return 1988693705;
    }
}
