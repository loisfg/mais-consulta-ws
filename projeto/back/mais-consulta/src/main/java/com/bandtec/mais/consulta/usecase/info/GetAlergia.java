package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.models.ListaObj;

public interface GetAlergia {
    ListaObj<Alergia> execute(Integer idUser);
}
