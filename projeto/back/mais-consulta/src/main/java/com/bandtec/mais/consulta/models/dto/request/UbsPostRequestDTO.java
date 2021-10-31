package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.domain.Endereco;
import com.bandtec.mais.consulta.domain.Ubs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class UbsPostRequestDTO {
    private String nome;
    private Endereco endereco;

    public static Ubs convertFromController(UbsPostRequestDTO ubsPostRequestDTO) {
        log.debug("CRIANDO UBS {}", ubsPostRequestDTO);
        return Ubs
                .builder()
                .nome(ubsPostRequestDTO.getNome())
                .endereco(ubsPostRequestDTO.getEndereco())
                .build();
    }
}
