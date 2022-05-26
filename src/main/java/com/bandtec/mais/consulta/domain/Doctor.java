package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Table(name = "Medico", schema = "dbo", indexes = {
        @Index(name = "idx_doctor_clinica_id", columnList = "clinica_id")
})
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Integer doctorId;

    @Column(name = "nome")
    private String name;

    @JoinColumn(name = "clinica_id", referencedColumnName = "id_clinica", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Clinic clinic;

    @JsonIgnore
    @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "especialidade_id", referencedColumnName = "id_especialidade", nullable = false)
    private Specialty specialty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Doctor doctor = (Doctor) o;

        return Objects.equals(doctorId, doctor.doctorId);
    }

    @Override
    public int hashCode() {
        return 47971316;
    }
}
