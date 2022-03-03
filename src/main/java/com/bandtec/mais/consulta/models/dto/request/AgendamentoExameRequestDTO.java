package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Exame;
import com.bandtec.mais.consulta.models.enums.AgendamentoStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class AgendamentoExameRequestDTO {
    LocalDate dtAtendimento;
    LocalTime hrAtendimento;
    String descricao;
    Integer idEspecialidade;
    Integer idPaciente;
    Integer idUbs;
    AgendamentoStatusEnum status;

    public static Exame convertFromController(AgendamentoExameRequestDTO agendamentoExameRequestDTO) {

        Agendamento agendamento = Agendamento
                .builder()
                .hrAtendimento(agendamentoExameRequestDTO.hrAtendimento)
                .dtAtendimento(agendamentoExameRequestDTO.dtAtendimento)
                .status(agendamentoExameRequestDTO.status)
                .build();


        return Exame
                .builder()
                .descricao(agendamentoExameRequestDTO.descricao)
                .agendamento(agendamento)
                .build();
    }
}
