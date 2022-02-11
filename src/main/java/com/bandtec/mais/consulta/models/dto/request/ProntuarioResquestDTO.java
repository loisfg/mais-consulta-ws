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
    private Iterable<Integer> doencas = null;
    private Iterable<Integer> remedios = null;
    private Iterable<Integer> alergias = null;
    private Iterable<Integer> deficiencia = null;
    private Iterable<Integer> atividadesProibidas = null;
    private boolean isFumante = false;
    private boolean isVirgem = false;
    private BloodTypeEnum tipoSanguineo = BloodTypeEnum.DEFAULT;
}
