package com.bandtec.mais.consulta.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "Clinica", schema = "dbo")
@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clinica")
    private Integer clinicId;

    @Column(name = "nome")
    private String name;

    @Column(name = "telefone")
    private String phone;

    @Column(name = "pix_key", nullable = false)
    private String pixKey;

    @Column(name = "preco", nullable = false)
    private String price;

    @JoinColumn(name = "endereco_id", referencedColumnName = "id_endereco", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Clinic clinic = (Clinic) o;

        return Objects.equals(clinicId, clinic.clinicId);
    }

    @Override
    public int hashCode() {
        return 1227588814;
    }
}
