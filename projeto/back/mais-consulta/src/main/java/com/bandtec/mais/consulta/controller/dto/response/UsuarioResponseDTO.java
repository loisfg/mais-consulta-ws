package com.bandtec.mais.consulta.controller.dto.response;

import com.bandtec.mais.consulta.models.dto.UsuarioAutenticadoDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class UsuarioResponseDTO {
    private UsuarioAutenticadoDTO usuario;
}
