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

    private String complaint;
    private String terminology;
    private String medicine;
    private String medicalGuidelines;
    private String certificate;

    @OneToOne
    @JoinColumn(name= "agendamento_id", referencedColumnName = "id_agendamento")
    private Scheduling scheduling;
}
