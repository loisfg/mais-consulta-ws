package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Remedio;

import java.util.List;

public interface GetRemedio {
    List<Remedio> execute(Integer idUser);
}
