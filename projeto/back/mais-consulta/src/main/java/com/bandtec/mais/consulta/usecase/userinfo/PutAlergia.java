package com.bandtec.mais.consulta.usecase.userinfo;

import com.bandtec.mais.consulta.domain.Alergia;

import java.util.Optional;

public interface PutAlergia {
    Optional<Alergia> execute(Integer id, Alergia alergia);
}
