package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Deficiency;

import java.util.List;

public interface GetDeficiency {
    List<Deficiency> execute(Integer userId);
}
