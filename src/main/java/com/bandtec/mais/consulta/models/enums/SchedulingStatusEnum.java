package com.bandtec.mais.consulta.models.enums;

public enum SchedulingStatusEnum {
    CANCELLED("CANCELADO", "Seu agendamento foi cancelado"),
    ACTIVE("ATIVO", "Seu agendamento está marcado"),
    HOLD("AGUARDE", "Seu agendamento está na fila de espera"),
    FINISHED("FINALIZADO", "Seu agendamento foi finalizado com sucesso");

    private final String description;
    private final String message;

    SchedulingStatusEnum(String description, String message) {
        this.description = description;
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }

    public static SchedulingStatusEnum schedulingStatus(String status) {
        return valueOf(status);
    }
}
