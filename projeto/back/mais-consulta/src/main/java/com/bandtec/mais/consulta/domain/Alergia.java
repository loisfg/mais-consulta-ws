package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "alergia")
public class Alergia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alergia")
    private Integer id;

    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "alergia")
    private Set<PacienteHasAlergia> pacienteAlergias;
}