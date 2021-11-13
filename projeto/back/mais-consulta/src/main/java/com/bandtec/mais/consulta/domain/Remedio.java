package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "remedio")
@Entity
public class Remedio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Campo de remédio está vazio!")
    private String nome;
    @NotNull(message = "Campo de controlado não está preenchido!")
    private Boolean controlado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Remedio remedio = (Remedio) o;

        return Objects.equals(id, remedio.id);
    }

    @Override
    public int hashCode() {
        return 1862138940;
    }
}