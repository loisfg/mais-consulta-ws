package com.bandtec.mais.consulta.usecase.search;

import com.bandtec.mais.consulta.domain.Doctor;

import java.util.Set;

public interface SearchEspecialidade {
    Set<Doctor> execute(String especialidade);
}
