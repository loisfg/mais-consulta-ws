package com.bandtec.mais.consulta.models.dto.request;

import com.bandtec.mais.consulta.models.enums.BloodTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProntuarioResquestDTO {
    private String peso = "";
    private Double altura = 0.0;
    private Iterable<Integer> doencas;
    private Iterable<Integer> remedios;
    private Iterable<Integer> alergias;
    private Iterable<Integer> deficiencia;
    private Iterable<Integer> atividadesProibidas;
    private boolean isFumante = false;
    private boolean isVirgem = false;
    private BloodTypeEnum tipoSanguineo = BloodTypeEnum.DEFAULT;
}
