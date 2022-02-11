package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "Doenca", schema = "dbo", catalog = "maisconsultadb")
@Entity
public class Doenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Boolean hereditaria = false;
    private Boolean cronico = false;
    private Boolean dst = false;

    @JsonIgnore
    @OneToMany(mappedBy = "doenca")
    @ToString.Exclude
    private Set<PacienteHasDoencas> pacienteHasDoencas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Doenca doenca = (Doenca) o;

        return Objects.equals(id, doenca.id);
    }

    @Override
    public int hashCode() {
        return 1283394514;
    }
}