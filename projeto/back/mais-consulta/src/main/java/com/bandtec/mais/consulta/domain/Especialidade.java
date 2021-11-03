package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "especialidade")
@Entity
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidade", nullable = false)
    private Integer idEspecialidade;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Transient
    @JsonIgnore
    @OneToMany(
            mappedBy = "especialidade",
            cascade = CascadeType.PERSIST
    )
    private Set<Medico> medicos = new HashSet<>();

    @OneToOne(mappedBy = "especialidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private Agendamento agendamento;
}

