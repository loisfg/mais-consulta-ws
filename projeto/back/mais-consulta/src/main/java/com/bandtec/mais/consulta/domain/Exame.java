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

    @JoinColumn(name = "agendamento_id", referencedColumnName = "id_agendamento", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected Agendamento agendamento;
}
