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
public class PatientHasDeficiencyKey implements Serializable{

    @Column(name = "paciente_id")
    Integer patientId;

    @Column(name = "deficiencia_id")
    Integer deficiencyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientHasDeficiencyKey that = (PatientHasDeficiencyKey) o;

        if (!Objects.equals(patientId, that.patientId)) return false;
        return Objects.equals(deficiencyId, that.deficiencyId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(patientId);
        result = 31 * result + (Objects.hashCode(deficiencyId));
        return result;
    }
}