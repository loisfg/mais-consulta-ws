package com.bandtec.mais.consulta.models.dto.response;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class PacienteAgendamentosResponseDTO {
    String especialidade;
    LocalDate dataAtendimento;
    String diaSemana;
    LocalTime horaAtendimento;

    public PacienteAgendamentosResponseDTO(String especialidade, LocalDate dataAtendimento, LocalTime horaAtendimento) {
        this.especialidade = especialidade;
        this.dataAtendimento = dataAtendimento;
        this.diaSemana = getDiaSemana(dataAtendimento);
        this.horaAtendimento = horaAtendimento;
    }

    private String getDiaSemana(LocalDate dataAtendimento) {
        switch (dataAtendimento.getDayOfWeek()) {
            case MONDAY : return "Segunda-Feira";
            case TUESDAY: return "Terca-Feira";
            case WEDNESDAY: return "Quarta-Feira";
            case THURSDAY: return "Quinta-Feira";
            case FRIDAY: return "Sexta-Feira";
            case SATURDAY: return "Sabádo";
            case SUNDAY: return "Domingo";
            default: return "Dia inexistente";
        }
    }

}