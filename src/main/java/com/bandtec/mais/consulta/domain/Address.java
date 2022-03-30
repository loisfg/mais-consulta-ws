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

    @Column(name = "cep")
    private String zipCode;

    @Column(name = "cidade")
    private String city;

    @Column(name = "estado")
    private String state;

    @Column(name = "bairro")
    private String district;

    @Column(name = "rua")
    private String street;

    @Column(name = "logradouro")
    private String publicPlace;

    @Column(name = "numero")
    private String number;

    @Column(name = "complemento")
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
