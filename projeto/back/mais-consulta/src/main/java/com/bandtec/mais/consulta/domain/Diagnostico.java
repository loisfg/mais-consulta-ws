package com.bandtec.mais.consulta.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Diagnostico", schema = "dbo", catalog = "maisconsultadb")
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diagnostico", nullable = false)
    private Integer idDiagnostico;

    private String queixa;
    private String terminologia;
    private String medicamento;
    private String orientacoesMedicas;
    private String atestado;

    @OneToOne
    @JoinColumn(name= "agendamento_id", referencedColumnName = "id_agendamento")
    private Agendamento agendamento;
}
