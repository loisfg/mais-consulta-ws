package com.bandtec.mais.consulta.usecase.search;

import com.bandtec.mais.consulta.domain.Doctor;

import java.util.List;

public interface SearchSpecialty {
    List<Doctor> execute(String specialty);
}
