package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Disease;

import java.util.List;

public interface PostDisease {
    List<Disease> execute(Iterable<Integer> diseasesId, Integer patientId);
}
