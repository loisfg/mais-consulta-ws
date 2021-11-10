package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "deficiencia")
@Entity
public class Deficiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deficiencia")
    private Integer id;
    private String nome;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id_paciente")
    private Paciente paciente;
}