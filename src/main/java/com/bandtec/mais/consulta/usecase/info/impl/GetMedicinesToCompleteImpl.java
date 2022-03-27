package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Medicine;
import com.bandtec.mais.consulta.gateway.repository.MedicineRepository;
import com.bandtec.mais.consulta.usecase.info.GetMedicinesToComplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GetMedicinesToCompleteImpl implements GetMedicinesToComplete {

    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public Optional<Set<Medicine>> execute(String name) {
        return medicineRepository.findByNameStartingWithIgnoreCase(name);
    }
}
