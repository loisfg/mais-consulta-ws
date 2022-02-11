package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.models.dto.DadosPessoaisDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class PacienteInfoPutResquestDTO {
    public DadosPessoaisDTO dadosPessoais;
    public ProntuarioResquestDTO prontuario;
}