package com.bandtec.mais.consulta.domain;

import com.bandtec.mais.consulta.models.enums.BloodTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "Paciente")
@Builder
@Table(name = "Paciente", schema = "dbo")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer patientId;

    @NotBlank
    private String name;

    @Column(name = "dt_nascimento")
    private LocalDate birthDate;

    private String phone;
    private String gender;

    @Column(name = "numero_carteira_sus")
    private String susNumberWallet;

    private String weight = "";
    private Double height = 0.0;
    private Boolean isVirgin = false;
    private Boolean isSmoker = false;
    private BloodTypeEnum bloodType = BloodTypeEnum.DEFAULT;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Address address;

    @JsonIgnore
    @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected User user;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<PatientHasDisease> diseases;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<PatientHasMedicine> medicines;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<PatientHasDeficiency> deficiencies;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<PatientHasAllergy> allergies;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<PatientHasActivity> activities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Patient patient = (Patient) o;

        return Objects.equals(patientId, patient.patientId);
    }

    @Override
    public int hashCode() {
        return 38015519;
    }
}
