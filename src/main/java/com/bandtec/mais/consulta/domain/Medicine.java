package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@Table(name = "Remedio", schema = "dbo", catalog = "maisconsultadb")
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineId;

    private String name;

    private Boolean controlled;

    @JsonIgnore
    @OneToMany(mappedBy = "remedio")
    @ToString.Exclude
    private Set<PatientHasMedicine> patientHasMedicine;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Medicine medicine = (Medicine) o;

        return Objects.equals(medicineId, medicine.medicineId);
    }

    @Override
    public int hashCode() {
        return 1862138940;
    }
}