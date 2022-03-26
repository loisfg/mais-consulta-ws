package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PacienteHasDoencas", schema = "dbo", catalog = "maisconsultadb")
public class PatientHasDisease {
    @EmbeddedId
    PatientHasDiseaseKey patientHasDiseasesId;

    @ManyToOne
    @JoinColumn(name = "doenca_id", insertable = false, updatable = false)
    private Disease disease;

    @ManyToOne
    @JoinColumn(name = "paciente_id", insertable = false, updatable = false)
    private Patient patient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientHasDisease that = (PatientHasDisease) o;

        return Objects.equals(patientHasDiseasesId, that.patientHasDiseasesId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(patientHasDiseasesId);
    }
}