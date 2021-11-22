package com.bandtec.mais.consulta.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Hora {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(columnDefinition = "TIME", insertable = false, updatable = false, unique = true)
    private LocalTime horas;
}
