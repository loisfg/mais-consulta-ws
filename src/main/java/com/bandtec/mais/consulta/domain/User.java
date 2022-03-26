package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "Usuario", indexes = {
        @Index(name = "idx_usuario_cpf", columnList = "cpf"),
        @Index(name = "idx_usuario_password", columnList = "password")
}, schema = "dbo", catalog = "maisconsultadb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer userId;

    @Column(nullable = false)
    private String cpf;
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;

        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return 1225039686;
    }
}
