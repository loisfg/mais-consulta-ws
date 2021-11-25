package com.bandtec.mais.consulta.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;

@Getter
public class MedicoAgendamentoDTO {

    Integer id;
    String nome;
    Integer idade;
    LocalTime hrAtendimento;

    public MedicoAgendamentoDTO(Integer id, String nome, LocalTime hrAtendimento, LocalDate dtNascimento) {
        this.id = id;
        this.nome = nome;
        this.idade = calculateAge(dtNascimento, LocalDate.now());
        this.hrAtendimento = hrAtendimento;
    }


    public Integer calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
