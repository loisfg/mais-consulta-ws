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
    @Column(name = "id_ubs")
    private Integer idUbs;

    private String nome;

    @PrimaryKeyJoinColumn(
            name = "id_endereco",
            referencedColumnName = "id_ubs"
    )
    @OneToOne(
            cascade = CascadeType.PERSIST
    )
    private Endereco endereco;
}
