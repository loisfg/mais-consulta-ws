package com.bandtec.mais.consulta.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "exame")
@Entity
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exame", nullable = false)
    private Integer idExame;

    private String descricao;

    @PrimaryKeyJoinColumn(name = "id_agendamento", referencedColumnName = "id_exame")
    @OneToOne(cascade = CascadeType.ALL)
    protected Agendamento agendamento;
}
