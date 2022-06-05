package com.bandtec.mais.consulta.usecase.search;

import com.bandtec.mais.consulta.domain.Doctor;

import java.util.List;

public interface SearchSpecialtyByDistrict {
    List<Doctor> execute(String specialty, String district);
}
