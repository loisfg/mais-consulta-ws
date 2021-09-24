package com.bandtec.mais.consulta.models.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class UsuarioAutenticadoDTO {

    private String idUser;
    private String nome;
    private String role;

}
