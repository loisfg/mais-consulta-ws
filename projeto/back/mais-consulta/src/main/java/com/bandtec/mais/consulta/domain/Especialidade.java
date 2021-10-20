package com.bandtec.mais.consulta.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "especialidade")
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEspecialidade", nullable = false)
    private Integer idEspecialidade;

    @Column(name = "descricao")
    private String descricao;

//    @PrimaryKeyJoinColumn(name = "idUbs", referencedColumnName = "idEspecialidade")
//    @OneToOne(cascade = CascadeType.ALL)
//    private Ubs ubs;


    @Override
    public String toString() {
        return "Especialidade{" +
                "idEspecialidade=" + idEspecialidade +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

