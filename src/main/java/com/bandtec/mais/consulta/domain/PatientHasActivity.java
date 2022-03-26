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
@Table(name = "PacienteHasAtividade", schema = "dbo", catalog = "maisconsultadb")
public class PatientHasActivity {
    @EmbeddedId
    private PatientHasActivityKey patientHasActivityId;

    @ManyToOne
    @JoinColumn(name = "paciente_id", insertable = false, updatable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "atividade_id", insertable = false, updatable = false)
    private Activity activity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientHasActivity that = (PatientHasActivity) o;
        return patientHasActivityId != null && Objects.equals(patientHasActivityId, that.patientHasActivityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientHasActivityId);
    }
}
