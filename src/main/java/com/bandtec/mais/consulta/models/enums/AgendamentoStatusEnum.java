package com.bandtec.mais.consulta.models.enums;

public enum AgendamentoStatusEnum {
    CANCELADO("CANCELADO", "Seu agendamento foi cancelado"),
    ATIVO("ATIVO", "Seu agendamento está marcado"),
    AGUARDE("AGUARDE", "Seu agendamento está na fila de espera"),
    FINALIZADO("FINALIZADO", "Seu agendamento foi finalizado com sucesso");

    private final String description;
    private final String message;

    AgendamentoStatusEnum(String description, String message){
        this.description = description;
        this.message = message;
    }

    public String getDescription(){
        return description;
    }

    public String getMessage() {
        return message;
    }

    public static AgendamentoStatusEnum statusAgendamento(String status) {
        return valueOf(status);
    }
}
