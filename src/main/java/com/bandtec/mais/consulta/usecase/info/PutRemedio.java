package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Remedio;

import java.util.Optional;

public interface PutRemedio {
    Optional<Remedio> execute(Integer id, Remedio remedio);
}