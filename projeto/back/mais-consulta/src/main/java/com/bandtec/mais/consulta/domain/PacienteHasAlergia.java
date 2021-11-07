package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class PacienteHasAlergia {
    @EmbeddedId
    PacienteHasAlergiaKey id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", insertable = false, updatable = false)
    Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "alergia_id", insertable = false, updatable = false)
    Alergia alergia;
}