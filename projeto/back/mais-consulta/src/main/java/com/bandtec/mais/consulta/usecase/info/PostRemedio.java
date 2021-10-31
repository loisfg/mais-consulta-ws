package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Remedio;

import java.util.Set;

public interface PostRemedio {
    Set<Remedio> execute(Set<Remedio> remedio, Integer id);
}
