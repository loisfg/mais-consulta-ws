package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Doenca;

import java.util.List;

public interface GetDoenca {
    List<Doenca> execute(Integer idUser);
}