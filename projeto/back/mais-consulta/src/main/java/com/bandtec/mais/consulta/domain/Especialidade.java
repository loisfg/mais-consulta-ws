package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "especialidade")
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidade", nullable = false)
    private Integer idEspecialidade;

    @Column(name = "descricao")
    private String descricao;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialidade")
    Set<Medico> medicos;

    @Override
    public String toString() {
        return new StringBuilder().append("Especialidade{")
                .append("idEspecialidade=")
                .append(idEspecialidade)
                .append(", descricao='").
                append(descricao)
                .append('\'')
                .toString();
    }
}

