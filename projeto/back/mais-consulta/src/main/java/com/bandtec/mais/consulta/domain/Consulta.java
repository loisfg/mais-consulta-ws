package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

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

    @PrimaryKeyJoinColumn(name = "id_especialidade", referencedColumnName = "id_consulta")
    @OneToOne(cascade = CascadeType.ALL)
    protected Especialidade especialidade;

    @PrimaryKeyJoinColumn(name = "id_agendamento", referencedColumnName = "id_consulta")
    @OneToOne(cascade = CascadeType.ALL)
    protected Agendamento agendamento;
}
