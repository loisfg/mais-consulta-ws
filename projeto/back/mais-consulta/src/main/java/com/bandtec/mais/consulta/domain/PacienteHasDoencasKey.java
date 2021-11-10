package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PacienteHasDoencasKey implements Serializable{

    @Column(name = "paciente_id")
    Integer pacienteId;

    @Column(name = "doenca_id")
    Integer doencaId;
}