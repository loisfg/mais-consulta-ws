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
@Table(name = "Atividade", schema = "dbo", catalog = "maisconsultadb")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atividade")
    private Integer activityId;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "atividade")
    @ToString.Exclude
    private Set<PatientHasActivity> patientHasActivities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Activity that = (Activity) o;
        return activityId != null && Objects.equals(activityId, that.activityId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
