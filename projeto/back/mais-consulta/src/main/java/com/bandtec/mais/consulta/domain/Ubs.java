package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "ubs")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ubs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUbs;

    @Column(name = "nome")
    private String nome;

    @PrimaryKeyJoinColumn(
            name = "idEndereco",
            referencedColumnName = "idUbs"
    )
    @OneToOne(
            cascade = CascadeType.PERSIST
    )
    private Endereco endereco;
}
