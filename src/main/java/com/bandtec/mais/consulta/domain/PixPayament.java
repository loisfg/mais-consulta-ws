package com.bandtec.mais.consulta.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "Pagamento", schema = "dbo")
@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PixPayament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Integer paymentId;

    @Column(name = "tx_id")
    private String tx_id;

    @Column(name = "e2id")
    private String e2id;

    @Column(name = "valor")
    private String amount;

    @Column(name = "chave")
    private String keyPix;

    @Column(name = "location")
    private String location;

    @Column(name = "dh_insert")
    private LocalDate dhInsert = LocalDate.now();

    @JoinColumn(name = "clinic_id", referencedColumnName = "id_clinica", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Clinic clinic;

    @JoinColumn(name = "pacient_id", referencedColumnName = "id_paciente", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;
}
