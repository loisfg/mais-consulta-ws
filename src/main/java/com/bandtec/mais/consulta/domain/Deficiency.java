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
@Table(name = "Deficiencia", schema = "dbo", catalog = "maisconsultadb")
@Entity
public class Deficiency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deficiencia")
    private Integer deficiencyId;
    
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "deficiencia")
    @ToString.Exclude
    private Set<PatientHasDeficiency> patientHasDeficiencies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Deficiency that = (Deficiency) o;

        return Objects.equals(deficiencyId, that.deficiencyId);
    }

    @Override
    public int hashCode() {
        return 1252939305;
    }
}