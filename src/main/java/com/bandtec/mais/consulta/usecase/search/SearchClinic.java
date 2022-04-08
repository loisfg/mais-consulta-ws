package com.bandtec.mais.consulta.usecase.search;

import com.bandtec.mais.consulta.domain.Clinic;
import org.hibernate.mapping.Any;

import java.util.List;

public interface SearchClinic {
    List<Clinic> execute(Integer id);

    List<Clinic> execute(String district);
}
