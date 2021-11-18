package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "ubs")
@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ubs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ubs")
    private Integer idUbs;

    private String nome;

    private String telefone;

    @JoinColumn(name = "endereco_id", referencedColumnName = "id_endereco", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ubs ubs = (Ubs) o;

        return Objects.equals(idUbs, ubs.idUbs);
    }

    @Override
    public int hashCode() {
        return 1227588814;
    }
}
