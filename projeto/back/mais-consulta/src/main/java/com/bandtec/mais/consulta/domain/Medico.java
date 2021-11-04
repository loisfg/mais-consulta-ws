package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "usuario")
@Builder
@Data
@Table(name = "medico")
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer idMedico;

    private String nome;

    @JsonIgnore
    @JoinColumn(name = "ubs_id", referencedColumnName = "id_ubs", nullable = false)
    @ManyToOne
    private Ubs ubs;

    @JsonIgnore
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "especialidade_id", referencedColumnName = "id_especialidade", nullable = false)
    private Especialidade especialidade;
}
