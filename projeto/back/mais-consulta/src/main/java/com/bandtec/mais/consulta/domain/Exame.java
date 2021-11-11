package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Exame exame = (Exame) o;

        return Objects.equals(idExame, exame.idExame);
    }

    @Override
    public int hashCode() {
        return 1988693705;
    }
}
