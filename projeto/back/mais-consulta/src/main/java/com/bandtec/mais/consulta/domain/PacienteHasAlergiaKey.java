package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PacienteHasAlergiaKey implements Serializable {

    @Column(name = "paciente_id")
    Integer paciente_id;

    @Column(name = "alergia_id")
    Integer alergia_id;
}
