package com.bandtec.mais.consulta.models.dto.request;


import com.bandtec.mais.consulta.domain.Paciente;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class UsuarioRequestDTO {

    private String cpf;
    private String password;
    private Paciente paciente;

}
