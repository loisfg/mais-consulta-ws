package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.domain.Especialidade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class AgendamentoConsultaRequestDTO {
    LocalDate dtAtendimento;
    LocalTime hrAtendimento;
    String descricao;
    Integer idEspecialidade;
    Integer idPaciente;
    Integer idUbs;
    String status;

    public static Consulta convertFromController(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO) {
        log.info("Consulta DTO {}", agendamentoConsultaRequestDTO);

        Agendamento agendamento = Agendamento
                .builder()
                .dhInsert(new Date())
                .dtAtendimento(agendamentoConsultaRequestDTO.dtAtendimento)
                .hrAtendimento(agendamentoConsultaRequestDTO.hrAtendimento)
                .build();

        return Consulta
                .builder()
                .descricao(agendamentoConsultaRequestDTO.descricao)
                .agendamento(agendamento)
                .build();
    }
}
