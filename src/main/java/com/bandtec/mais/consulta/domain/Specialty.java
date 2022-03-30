package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "Especialidade", schema = "dbo", catalog = "maisconsultadb")
@Entity
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidade")
    private Integer specialtyId;

    @Column(nullable = false, name = "descricao")
    private String description;

    @Transient
    @JsonIgnore
    @OneToMany(mappedBy = "especialidade", cascade = CascadeType.ALL)
    private Set<Doctor> doctors = new HashSet<>();

    @Transient
    @JsonIgnore
    @OneToOne(mappedBy = "especialidade")
    private Scheduling scheduling;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Specialty that = (Specialty) o;

        return Objects.equals(specialtyId, that.specialtyId);
    }

    @Override
    public int hashCode() {
        return 608832936;
    }
}

