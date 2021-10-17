package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Agendamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AgendamentoRequestDTO {
    LocalDate dtHr = LocalDate.now();
    LocalDate dtAtendimento;
    String especialidade;
    Agendamento agendamento;
}
