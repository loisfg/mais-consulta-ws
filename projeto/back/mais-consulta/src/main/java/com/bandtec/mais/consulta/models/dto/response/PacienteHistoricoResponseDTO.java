package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.utils.StrFormat;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class PacienteHistoricoResponseDTO {
    Integer idAgendamento;
    LocalDate dtAtendimento;
    LocalTime horaAtendimento;
    String especialidade;
    String nomeMedico;
    String nomeUbs;

    public PacienteHistoricoResponseDTO(Integer idAgendamento, LocalDate dtAtendimento, LocalTime horaAtendimento, String especialidade, String nomeMedico, String nomeUbs) {
        this.idAgendamento = idAgendamento;
        this.dtAtendimento = dtAtendimento;
        this.horaAtendimento = horaAtendimento;
        this.especialidade = especialidade;
        this.nomeMedico = nomeMedico;
        this.nomeUbs = StrFormat.toTitledCase(nomeUbs);
    }
}
