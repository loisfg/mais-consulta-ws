package com.bandtec.mais.consulta.models.dto.infocadastro;

import com.bandtec.mais.consulta.domain.Alergia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlergiaDTO {
    private String nome;

}
