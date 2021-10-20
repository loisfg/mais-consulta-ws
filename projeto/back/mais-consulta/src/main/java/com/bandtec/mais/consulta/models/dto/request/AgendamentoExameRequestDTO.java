package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.domain.Exame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class AgendamentoExameRequestDTO {
    LocalDate dtHr = LocalDate.now();
    LocalDate dtAtendimento;
    Especialidade especialidade;
    String descricao;
    Integer idPaciente;
    Integer idMedico;
    Integer idUbs;

    public static Exame convertFromController(AgendamentoExameRequestDTO agendamentoExameRequestDTO) {
        log.info("Exame DTO {}", agendamentoExameRequestDTO);

        Exame exame = new Exame();
        Agendamento agendamento = new Agendamento();

        exame.setDescricao(agendamentoExameRequestDTO.getDescricao());
        exame.setAgendamento(agendamento);

        exame.getAgendamento().setDtAtendimento(agendamentoExameRequestDTO.getDtAtendimento());
        exame.getAgendamento().setEspecialidade(agendamentoExameRequestDTO.getEspecialidade());

        return exame;
    }
}
