package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.intellij.lang.annotations.RegExp;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "consulta")
@Entity
public class  Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer idConsulta;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @JsonIgnore
    @JoinColumn(name = "agendamento_id", referencedColumnName = "id_agendamento", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected Agendamento agendamento;
}
