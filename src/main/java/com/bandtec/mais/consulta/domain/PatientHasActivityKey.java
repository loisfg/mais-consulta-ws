package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PatientHasActivityKey implements Serializable {
    @Column(name = "paciente_id")
    Integer patientId;

    @Column(name = "atividade_id")
    Integer activityId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientHasActivityKey that = (PatientHasActivityKey) o;
        return patientId != null && Objects.equals(patientId, that.patientId)
                && activityId != null && Objects.equals(activityId, that.activityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, activityId);
    }
}
