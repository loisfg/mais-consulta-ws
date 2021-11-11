package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "notification")
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private Integer idNotification;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "insert_dt")
    private LocalDateTime insertDt;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInsertDt() {
        return insertDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Notification that = (Notification) o;

        return Objects.equals(idNotification, that.idNotification);
    }

    @Override
    public int hashCode() {
        return 436862861;
    }
}
