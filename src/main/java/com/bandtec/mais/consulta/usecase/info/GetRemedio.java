package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Medicine;

import java.util.List;

public interface GetRemedio {
    List<Medicine> execute(Integer idUser);
}
