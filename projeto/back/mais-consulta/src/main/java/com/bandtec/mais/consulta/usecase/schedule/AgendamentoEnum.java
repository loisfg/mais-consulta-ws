package com.bandtec.mais.consulta.usecase.schedule;

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
