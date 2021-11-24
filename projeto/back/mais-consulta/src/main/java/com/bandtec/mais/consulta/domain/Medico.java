package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "usuario")
@Builder
@Getter
@Setter
@Table(name = "medico")
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer idMedico;

    private String nome;

    @JsonIgnore
    @JoinColumn(name = "ubs_id", referencedColumnName = "id_ubs", nullable = false)
    @ManyToOne
    private Ubs ubs;

    @JsonIgnore
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "especialidade_id", referencedColumnName = "id_especialidade", nullable = false)
    private Especialidade especialidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Medico medico = (Medico) o;

        return Objects.equals(idMedico, medico.idMedico);
    }

    @Override
    public int hashCode() {
        return 47971316;
    }
}
