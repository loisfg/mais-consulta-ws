package com.bandtec.mais.consulta.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "doenca")
@Entity
public class Doenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Boolean hereditaria = false;
    private Boolean cronico = false;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id_paciente")
    private Paciente paciente;
}