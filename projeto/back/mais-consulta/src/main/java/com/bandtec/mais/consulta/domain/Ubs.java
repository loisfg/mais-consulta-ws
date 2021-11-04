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

//    @JoinColumn
//    @ManyToMany()
//    Medico medico;

    @JoinColumn(name = "endereco_id", referencedColumnName = "id_endereco", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
}
