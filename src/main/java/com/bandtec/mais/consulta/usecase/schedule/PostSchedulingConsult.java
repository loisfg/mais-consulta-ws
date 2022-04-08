package com.bandtec.mais.consulta.usecase.schedule;

import com.bandtec.mais.consulta.domain.Consult;
import com.bandtec.mais.consulta.models.dto.request.ConsultSchedulingRequestDTO;

import java.util.Optional;

public interface PostSchedulingConsult {
    Optional<Consult> execute(ConsultSchedulingRequestDTO consultSchedulingRequestDTO);
}
