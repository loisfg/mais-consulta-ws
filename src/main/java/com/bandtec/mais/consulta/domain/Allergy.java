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
@Entity
@Table(name = "Alergia", schema = "dbo", catalog = "maisconsultadb")
public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alergia")
    private Integer allergyId;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "alergia")
    @ToString.Exclude
    private Set<PatientHasAllergy> allergyPatients;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Allergy allergy = (Allergy) o;

        return Objects.equals(allergyId, allergy.allergyId);
    }

    @Override
    public int hashCode() {
        return 1736075589;
    }
}