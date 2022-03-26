package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "Doenca", schema = "dbo", catalog = "maisconsultadb")
@Entity
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diseaseId;

    private String name;
    private Boolean hereditary = false;
    private Boolean chronic = false;
    private Boolean std = false;

    @JsonIgnore
    @OneToMany(mappedBy = "doenca")
    @ToString.Exclude
    private Set<PatientHasDisease> patientHasDiseases;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Disease disease = (Disease) o;

        return Objects.equals(diseaseId, disease.diseaseId);
    }

    @Override
    public int hashCode() {
        return 1283394514;
    }
}