package com.bandtec.mais.consulta.models.dto;

import com.bandtec.mais.consulta.domain.*;
import com.bandtec.mais.consulta.models.enums.BloodTypeEnum;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ProntuarioDTO {
    private String peso = "";
    private Double altura = 0.0;
    private List<Doenca> doencasCronicas;
    private List<Remedio> remediosControlados;
    private List<Alergia> alergias;
    private List<Doenca> dsts;
    private List<Deficiencia> deficiencia;
    private boolean isFumante = false;
    private boolean isVirgem = false;
    private List<Doenca> doencasHereditarias;
    private BloodTypeEnum tipoSanguineo = BloodTypeEnum.DEFAULT;
    private List<Atividade> atividadesProibidas;
}
