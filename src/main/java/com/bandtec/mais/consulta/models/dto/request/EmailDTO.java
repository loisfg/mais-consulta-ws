package com.bandtec.mais.consulta.models.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDTO {
    @NotBlank
    private String ownerRef;
    @NotBlank
    @Email
    private String emailFrom;
    private String emailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;
}
