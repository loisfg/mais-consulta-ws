package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UbsPostRequestDTO {
    private String nome;
    private Endereco endereco;
}
