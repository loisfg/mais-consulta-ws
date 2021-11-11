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
@RequiredArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PacienteHasDeficienciaKey implements Serializable{

    @Column(name = "paciente_id")
    Integer pacienteId;

    @Column(name = "deficiencia_id")
    Integer deficienciaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PacienteHasDeficienciaKey that = (PacienteHasDeficienciaKey) o;

        if (!Objects.equals(pacienteId, that.pacienteId)) return false;
        return Objects.equals(deficienciaId, that.deficienciaId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(pacienteId);
        result = 31 * result + (Objects.hashCode(deficienciaId));
        return result;
    }
}