package com.bandtec.mais.consulta.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDTO {
    private String descricao;
    private LocalDateTime insertDt;
}
