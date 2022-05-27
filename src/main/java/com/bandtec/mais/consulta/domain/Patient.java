package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;

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
    @Column(name = "nome")
    private String name;

    @Column(name = "dt_nascimento")
    private LocalDate birthDate;

    @Column(name = "telefone")
    private String phone;

    @Column(name = "sexo")
    private String gender;

    @Column(name = "numero_carteira")
    private String numberWallet;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Address address;

    @JsonIgnore
    @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    protected User user;

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
