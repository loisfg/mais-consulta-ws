package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.models.dto.DadosPessoaisDTO;
import com.bandtec.mais.consulta.models.dto.ProntuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteInfoRequestDTO {

    private Integer idAgendamento;
    private DadosPessoaisDTO dadosPessoais;
    private ProntuarioResquestDTO prontuario;

}
