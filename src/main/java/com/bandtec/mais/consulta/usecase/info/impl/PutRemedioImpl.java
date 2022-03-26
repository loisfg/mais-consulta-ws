package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Medicine;
import com.bandtec.mais.consulta.gateway.repository.RemedioRepository;
import com.bandtec.mais.consulta.usecase.info.PutRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutRemedioImpl implements PutRemedio {

    @Autowired
    private RemedioRepository remedioRepository;

    @Override
    public Optional<Medicine> execute(Integer id, Medicine medicine) {

        if (remedioRepository.existsById(id)) {
            medicine.setMedicineId(id);
            return Optional.of(remedioRepository.save(medicine));
        }

        return Optional.empty();
    }
}
