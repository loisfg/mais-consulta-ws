package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Medicine;

import java.util.List;

public interface GetMedicine {
    List<Medicine> execute(Integer userId);
}
