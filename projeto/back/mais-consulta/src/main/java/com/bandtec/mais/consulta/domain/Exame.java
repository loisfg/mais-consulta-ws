package com.bandtec.mais.consulta.domain;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "exame", indexes = {
        @Index(name = "idx_exame_id_exame", columnList = "id_exame")
})
@Entity
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exame", nullable = false)
    private Integer idExame;

    @Column(name = "descricao")
    private String descricao;

    @PrimaryKeyJoinColumn(name = "id_agendamento", referencedColumnName = "id_exame")
    @OneToOne(cascade = CascadeType.ALL)
    protected Agendamento agendamento;

}
