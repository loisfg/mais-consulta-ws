package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Table(name = "Notification", schema = "dbo", catalog = "maisconsultadb")
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

    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setInsertDt(LocalDateTime insertDt) {
        this.insertDt = insertDt;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
