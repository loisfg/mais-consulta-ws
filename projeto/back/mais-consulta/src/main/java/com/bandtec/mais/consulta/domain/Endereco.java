package com.bandtec.mais.consulta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    private String cep;
    private String cidade;
    private String estado;
    private String bairro;
    private String rua;
    private String logradouro;
    private String numero;
    private String complemento;

    //TODO retirar JsonIgnore e adicionar DTO's para retorno dos métodos!
    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private Paciente paciente;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private Ubs ubs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Endereco endereco = (Endereco) o;

        return Objects.equals(idEndereco, endereco.idEndereco);
    }

    @Override
    public int hashCode() {
        return 1380307530;
    }
}
