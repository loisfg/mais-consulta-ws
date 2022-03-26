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
public class PatientHasAllergyKey implements Serializable {

    @Column(name = "paciente_id")
    Integer patientId;

    @Column(name = "alergia_id")
    Integer allergyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientHasAllergyKey that = (PatientHasAllergyKey) o;

        if (!Objects.equals(patientId, that.patientId)) return false;
        return Objects.equals(allergyId, that.allergyId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(patientId);
        result = 31 * result + (Objects.hashCode(allergyId));
        return result;
    }
}
