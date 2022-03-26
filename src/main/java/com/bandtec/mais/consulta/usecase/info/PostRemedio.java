package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Medicine;

import java.util.List;

public interface PostRemedio {
    List<Medicine> execute(Iterable<Integer> remedios, Integer id);
}
