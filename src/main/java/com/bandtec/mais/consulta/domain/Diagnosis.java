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
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diagnostico", nullable = false)
    private Integer diagnosisId;

    @Column(name = "queixa")
    private String complaint;

    @Column(name = "terminologia")
    private String terminology;

    @Column(name = "medicamento")
    private String medicine;

    @Column(name = "orientacoes_medicas")
    private String medicalGuidelines;

    @Column(name = "atestado")
    private String certificate;

    @OneToOne
    @JoinColumn(name = "agendamento_id", referencedColumnName = "id_agendamento")
    private Scheduling scheduling;
}
