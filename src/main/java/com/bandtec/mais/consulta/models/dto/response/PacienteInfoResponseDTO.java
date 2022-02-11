package com.bandtec.mais.consulta.models.dto.response;

import com.bandtec.mais.consulta.models.dto.DadosPessoaisDTO;
import com.bandtec.mais.consulta.models.dto.ProntuarioDTO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PacienteInfoResponseDTO {
    public DadosPessoaisDTO dadosPessoais;
    public ProntuarioDTO prontuario;
}
