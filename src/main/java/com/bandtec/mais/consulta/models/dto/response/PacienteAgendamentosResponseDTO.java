package com.bandtec.mais.consulta.models.dto.response;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class PacienteAgendamentosResponseDTO {
    Integer idAgendamento;
    String especialidade;
    LocalDate dataAtendimento;
    String diaSemana;
    LocalTime horaAtendimento;

    public PacienteAgendamentosResponseDTO(Integer idAgendamento, String especialidade, LocalDate dataAtendimento, LocalTime horaAtendimento) {
        this.idAgendamento = idAgendamento;
        this.especialidade = especialidade;
        this.dataAtendimento = dataAtendimento;
        this.diaSemana = getDiaSemana(dataAtendimento);
        this.horaAtendimento = horaAtendimento;
    }

    private String getDiaSemana(LocalDate dataAtendimento) {
        switch (dataAtendimento.getDayOfWeek()) {
            case MONDAY : return "Segunda";
            case TUESDAY: return "Terça";
            case WEDNESDAY: return "Quarta";
            case THURSDAY: return "Quinta";
            case FRIDAY: return "Sexta";
            case SATURDAY: return "Sabádo";
            case SUNDAY: return "Domingo";
            default: return "Dia inexistente";
        }
    }

}