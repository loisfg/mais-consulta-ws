package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Deficiencia;

import java.util.List;

public interface GetDeficiencia {
    List<Deficiencia> execute(Integer idUser);
}