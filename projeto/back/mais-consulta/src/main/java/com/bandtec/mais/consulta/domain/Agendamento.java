package com.bandtec.mais.consulta.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Table(name = "agendamento")
@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAgendamento;

    @Column(name = "dataHr")
    private LocalDate dataHr;

    @Column(name = "especialidade")
    private Integer especialidade;

    @PrimaryKeyJoinColumn(name = "idUsuario", referencedColumnName = "idAgendamento")
    @OneToOne(cascade = CascadeType.ALL)
    protected Usuario usuario;

    @PrimaryKeyJoinColumn(name = "idMedico", referencedColumnName = "idAgendamento")
    @OneToOne(cascade = CascadeType.ALL)
    protected Medico medico;

}
