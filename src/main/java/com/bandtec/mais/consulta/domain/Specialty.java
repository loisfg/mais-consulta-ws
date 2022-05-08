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
@Table(name = "Especialidade", schema = "dbo", catalog = "maisconsultadb", indexes = {
        @Index(name = "idx_specialty_descricao", columnList = "descricao")
})
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
    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL)
    private Set<Doctor> doctors = new HashSet<>();

    @Transient
    @JsonIgnore
    @OneToOne(mappedBy = "specialty")
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

