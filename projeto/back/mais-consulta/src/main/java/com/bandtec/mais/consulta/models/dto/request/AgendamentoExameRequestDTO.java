package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Consulta;
import com.bandtec.mais.consulta.domain.Exame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AgendamentoExameRequestDTO {
    LocalDate dtHr = LocalDate.now();
    LocalDate dtAtendimento;
    String especialidade;
    Exame exame;
    Integer idPaciente;
    Integer idMedico;
    Integer idUbs;
}
