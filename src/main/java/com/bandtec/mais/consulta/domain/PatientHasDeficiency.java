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
@Table(name = "PacienteHasDeficiencia", schema = "dbo", catalog = "maisconsultadb")
public class PatientHasDeficiency {
    @EmbeddedId
    private PatientHasDeficiencyKey patientHasDeficiencyId;

    @ManyToOne
    @JoinColumn(name = "paciente_id", insertable = false, updatable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "deficiencia_id", insertable = false, updatable = false)
    private Deficiency deficiency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientHasDeficiency that = (PatientHasDeficiency) o;

        return Objects.equals(patientHasDeficiencyId, that.patientHasDeficiencyId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(patientHasDeficiencyId);
    }
}