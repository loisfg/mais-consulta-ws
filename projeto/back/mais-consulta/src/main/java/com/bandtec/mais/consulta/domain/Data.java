package com.bandtec.mais.consulta.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Data {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(columnDefinition = "DATE", updatable = false, unique = true)
    LocalDate datasAtendimento;
}
