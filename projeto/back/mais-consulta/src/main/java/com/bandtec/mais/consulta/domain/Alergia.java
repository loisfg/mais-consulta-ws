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
@Entity
@Table(name = "alergia")
public class Alergia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alergia")
    private Integer id;

    private String nome;

//    @JsonIgnore
//    @OneToMany(mappedBy = "alergia")
//    @ToString.Exclude
//    private Set<PacienteHasAlergia> pacienteAlergias;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id_paciente")
    private Paciente paciente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Alergia alergia = (Alergia) o;

        return Objects.equals(id, alergia.id);
    }

    @Override
    public int hashCode() {
        return 1736075589;
    }
}