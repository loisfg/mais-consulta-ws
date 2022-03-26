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
@Table(name = "PacienteHasRemedios", schema = "dbo", catalog = "maisconsultadb")
public class PatientHasMedicine {
    @EmbeddedId
    PatientHasMedicinesKey patientHasMedicinesId;

    @ManyToOne
    @JoinColumn(name = "paciente_id", insertable = false, updatable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "remedio_id", insertable = false, updatable = false)
    private Medicine medicine;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientHasMedicine that = (PatientHasMedicine) o;

        return Objects.equals(patientHasMedicinesId, that.patientHasMedicinesId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(patientHasMedicinesId);
    }
}