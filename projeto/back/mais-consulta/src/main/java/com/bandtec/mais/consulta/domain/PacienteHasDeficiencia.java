package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PacienteHasDeficiencia {
    @EmbeddedId
    PacienteHasDeficienciaKey id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", insertable = false, updatable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "deficiencia_id", insertable = false, updatable = false)
    private Deficiencia deficiencia;
}