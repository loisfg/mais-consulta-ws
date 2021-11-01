package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.domain.Exame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class AgendamentoExameRequestDTO {
    LocalDate dtAtendimento;
    LocalTime hrAtendimento;
    Especialidade especialidade;
    String descricao;
    Integer idPaciente;
    Integer idMedico;
    Integer idUbs;

    public static Exame convertFromController(AgendamentoExameRequestDTO agendamentoExameRequestDTO) {
        Agendamento agendamento = Agendamento
                .builder()
                .hrAtendimento(agendamentoExameRequestDTO.hrAtendimento)
                .dhInsert(LocalDateTime.now())
                .dtAtendimento(agendamentoExameRequestDTO.dtAtendimento)
                .build();

        return Exame.builder()
                .descricao(agendamentoExameRequestDTO.descricao)
                .agendamento(agendamento)
                .build();
    }
}
