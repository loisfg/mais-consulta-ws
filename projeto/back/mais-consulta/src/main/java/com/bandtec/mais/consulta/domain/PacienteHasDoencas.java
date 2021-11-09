package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PacienteHasDoencas {
    @EmbeddedId
    PacienteHasDoencasKey id;

    @ManyToOne
    @JoinColumn(name = "doenca_id", insertable = false, updatable = false)
    private Doenca doenca;

    @ManyToOne
    @JoinColumn(name = "paciente_id", insertable = false, updatable = false)
    private Paciente paciente;
}