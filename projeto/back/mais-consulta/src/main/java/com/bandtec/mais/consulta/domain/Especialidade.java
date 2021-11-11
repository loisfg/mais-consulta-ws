package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Table(name = "especialidade")
@Entity
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidade")
    private Integer idEspecialidade;

    @Column(nullable = false)
    private String descricao;

    @Transient
    @JsonIgnore
    @OneToMany(mappedBy = "especialidade", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Medico> medicos = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "especialidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private Agendamento agendamento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Especialidade that = (Especialidade) o;

        return Objects.equals(idEspecialidade, that.idEspecialidade);
    }

    @Override
    public int hashCode() {
        return 608832936;
    }
}

