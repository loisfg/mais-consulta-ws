package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name = "PacienteHasAlergia", schema = "dbo", catalog = "maisconsultadb")
public class PatientHasAllergy {
    @EmbeddedId
    PatientHasAllergyKey patientHasAllergyId;

    @ManyToOne
    @JoinColumn(name = "paciente_id", insertable = false, updatable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "alergia_id", insertable = false, updatable = false)
    private Allergy allergy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientHasAllergy that = (PatientHasAllergy) o;

        return Objects.equals(patientHasAllergyId, that.patientHasAllergyId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(patientHasAllergyId);
    }
}