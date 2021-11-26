package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "deficiencia")
@Entity
public class Deficiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deficiencia")
    private Integer id;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "deficiencia")
    @ToString.Exclude
    private Set<PacienteHasDeficiencia> pacienteHasDeficiencias;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Deficiencia that = (Deficiencia) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1252939305;
    }
}