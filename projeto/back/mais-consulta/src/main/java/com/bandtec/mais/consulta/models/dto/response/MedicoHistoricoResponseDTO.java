package com.bandtec.mais.consulta.models.dto.response;

import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;

@Getter
public class MedicoHistoricoResponseDTO {
    Integer idAgendamento;
    String nome;
    Integer idade;
    LocalDate ultimoAtendimento;

    public MedicoHistoricoResponseDTO(Integer idAgendamento, String nome, LocalDate dataNascimento, LocalDate dtAtendimento) {
        this.idAgendamento = idAgendamento;
        this.nome = nome;
        this.idade = calculateAge(dataNascimento);
        this.ultimoAtendimento = dtAtendimento;
    }

    public static Integer calculateAge(LocalDate birthDate) {
        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}
