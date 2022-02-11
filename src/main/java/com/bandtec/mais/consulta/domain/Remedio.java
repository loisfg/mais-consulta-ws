package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@Table(name = "Remedio", schema = "dbo", catalog = "maisconsultadb")
@Entity
public class Remedio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Boolean controlado;

    @JsonIgnore
    @OneToMany(mappedBy = "remedio")
    @ToString.Exclude
    private Set<PacienteHasRemedios> pacienteHasRemedios;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Remedio remedio = (Remedio) o;

        return Objects.equals(id, remedio.id);
    }

    @Override
    public int hashCode() {
        return 1862138940;
    }
}