package com.bandtec.mais.consulta.usecase.info;

import com.bandtec.mais.consulta.domain.Medicine;

import java.util.Optional;

public interface PutMedicine {
    Optional<Medicine> execute(Integer id, Medicine medicine);
}
