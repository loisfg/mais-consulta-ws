package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Consulta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class AgendamentoConsultaRequestDTO {
    LocalDate dtAtendimento;
    String especialidade;
    String descrição;
    Integer idPaciente;
    Integer idMedico;
    Integer idUbs;

    public static Consulta convertFromController(AgendamentoConsultaRequestDTO agendamentoConsultaRequestDTO) {
        log.info("Consulta DTO {}", agendamentoConsultaRequestDTO);
        return new Consulta(
                agendamentoConsultaRequestDTO.getDescrição(),
                new Agendamento(
                        agendamentoConsultaRequestDTO.getDtAtendimento(),
                        agendamentoConsultaRequestDTO.getEspecialidade()
                )
        );
    }
}
