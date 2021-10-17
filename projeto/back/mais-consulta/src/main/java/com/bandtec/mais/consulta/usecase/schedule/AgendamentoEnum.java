package com.bandtec.mais.consulta.usecase.schedule;

public enum AgendamentoEnum {
    GERAL("Clinico Geral", 0),
    OUTROS("", 1);

    private final String description;
    private final Integer value;

    AgendamentoEnum(String description, Integer value){
        this.description = description;
        this.value = value;
    }

    public String getDescription(){
        return description;
    }

    public Integer getValue() {
        return value;
    }
}
