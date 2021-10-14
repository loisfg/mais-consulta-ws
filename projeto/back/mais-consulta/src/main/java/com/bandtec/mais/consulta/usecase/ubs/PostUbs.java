package com.bandtec.mais.consulta.usecase.ubs;

import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.models.dto.request.UbsPostRequestDTO;

import java.util.Optional;

public interface PostUbs {
    Optional<Ubs> execute(UbsPostRequestDTO ubsPostRequestDTO);
}
