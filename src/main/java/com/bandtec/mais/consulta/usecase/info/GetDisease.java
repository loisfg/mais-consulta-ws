package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Disease;

import java.util.List;

public interface GetDisease {
    List<Disease> execute(Integer userId);
}
