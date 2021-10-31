package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Alergia;

import java.util.Set;

public interface PostAlergia {
    Set<Alergia> execute(Set<Alergia> alergia, Integer id);
}
