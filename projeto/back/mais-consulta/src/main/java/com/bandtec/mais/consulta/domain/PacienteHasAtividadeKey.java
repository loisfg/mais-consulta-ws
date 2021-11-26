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
public class PacienteHasAtividadeKey implements Serializable {
    @Column(name = "paciente_id")
    Integer pacienteId;

    @Column(name = "atividade_id")
    Integer atividadeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PacienteHasAtividadeKey that = (PacienteHasAtividadeKey) o;
        return pacienteId != null && Objects.equals(pacienteId, that.pacienteId)
                && atividadeId != null && Objects.equals(atividadeId, that.atividadeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pacienteId, atividadeId);
    }
}
