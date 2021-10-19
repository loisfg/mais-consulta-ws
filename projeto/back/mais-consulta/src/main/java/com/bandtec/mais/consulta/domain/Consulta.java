package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "consulta")
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConsulta", nullable = false)
    private Integer idConsulta;

    @Column(name = "descricao")
    private String descricao;

    @PrimaryKeyJoinColumn(name = "idAgendamento", referencedColumnName = "idConsulta")
    @OneToOne(cascade = CascadeType.ALL)
    protected Agendamento agendamento;

    public Consulta(String descricao, Agendamento agendamento) {
        this.descricao = descricao;
        this.agendamento = agendamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(idConsulta, consulta.idConsulta);
    }
}