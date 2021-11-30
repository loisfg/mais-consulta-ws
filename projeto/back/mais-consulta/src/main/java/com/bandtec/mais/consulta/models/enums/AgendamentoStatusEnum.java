package com.bandtec.mais.consulta.models.enums;

import com.bandtec.mais.consulta.utils.StrFormat;

public enum AgendamentoStatusEnum {
    GERAL(StrFormat.toTitledCase("Clinico Geral")),
    OUTROS("");

    private final String description;

    AgendamentoStatusEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
