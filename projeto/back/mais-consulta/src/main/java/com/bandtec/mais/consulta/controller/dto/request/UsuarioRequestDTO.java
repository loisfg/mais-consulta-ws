package com.bandtec.mais.consulta.controller.dto.request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class UsuarioRequestDTO {

    private String login;
    private String password;

}
