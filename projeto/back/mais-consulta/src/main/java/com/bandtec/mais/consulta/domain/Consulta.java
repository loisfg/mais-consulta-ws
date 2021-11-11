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
@Table(name = "consulta")
@Entity
public class  Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Integer idConsulta;

    private String descricao;


    @JoinColumn(name = "agendamento_id", referencedColumnName = "id_agendamento", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected Agendamento agendamento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Consulta consulta = (Consulta) o;

        return Objects.equals(idConsulta, consulta.idConsulta);
    }

    @Override
    public int hashCode() {
        return 1651655778;
    }
}
