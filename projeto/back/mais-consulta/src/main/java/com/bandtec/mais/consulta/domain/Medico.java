package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

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

    @Column(name = "nome")
    private String nome;

    @JsonIgnore
    @PrimaryKeyJoinColumn(
            name = "id_usuario",
            referencedColumnName = "id_medico"
    )
    @OneToOne(
            cascade = CascadeType.ALL
    )
    protected Usuario usuario;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "especialidade_id",
            referencedColumnName = "id_especialidade"
    )
    private Especialidade especialidade;
}
