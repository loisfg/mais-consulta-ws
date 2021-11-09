package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Alergia;

import java.util.List;

public interface GetAlergia {
    List<Alergia> execute(Integer idUser);
}
