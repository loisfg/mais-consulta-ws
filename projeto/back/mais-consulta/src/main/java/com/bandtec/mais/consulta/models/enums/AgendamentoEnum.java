package com.bandtec.mais.consulta.models.enums;

import com.bandtec.mais.consulta.utils.StrFormat;

public enum AgendamentoEnum {
    GERAL(StrFormat.toTitledCase("Clinico Geral")),
    OUTROS("");

    private final String description;

    AgendamentoEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
