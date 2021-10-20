package com.bandtec.mais.consulta.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "exame")
@Entity
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idExame", nullable = false)
    private Integer idExame;

    @Column(name = "descricao")
    private String descricao;

    @PrimaryKeyJoinColumn(name = "idAgendamento", referencedColumnName = "idExame")
    @OneToOne(cascade = CascadeType.ALL)
    protected Agendamento agendamento;

}
