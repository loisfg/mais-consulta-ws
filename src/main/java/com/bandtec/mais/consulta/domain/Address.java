package com.bandtec.mais.consulta.domain;

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
@Table(name = "Endereco", schema = "dbo", catalog = "maisconsultadb")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer addressId;

    private String zipCode;
    private String city;
    private String state;
    private String district;
    private String street;
    private String publicPlace;
    private String number;
    private String complement;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Address address = (Address) o;

        return Objects.equals(addressId, address.addressId);
    }

    @Override
    public int hashCode() {
        return 1380307530;
    }
}
