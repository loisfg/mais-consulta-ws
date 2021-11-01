package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.domain.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class AgendamentoConsultaRequestDTO {
    LocalDate dtAtendimento;
    Especialidade especialidade;
    String descricao;
    Integer idPaciente;
    Integer idMedico;
    Integer idUbs;

    public static Consulta convertFromController(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO) {
        log.info("Consulta DTO {}", agendamentoConsultaRequestDTO);

        Consulta consulta = new Consulta();

        Agendamento agendamento = new Agendamento();

        consulta.setDescricao(agendamentoConsultaRequestDTO.getDescricao());
        consulta.setEspecialidade(agendamentoConsultaRequestDTO.getEspecialidade());
        consulta.setAgendamento(agendamento);

        consulta.getAgendamento().setDhInsert(LocalDateTime.now());
        consulta.getAgendamento().setDtAtendimento(agendamentoConsultaRequestDTO.getDtAtendimento());
        consulta.getAgendamento().setEspecialidade(agendamentoConsultaRequestDTO.getEspecialidade());

        return consulta;
    }
}
