package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Medicine;
import com.bandtec.mais.consulta.gateway.repository.MedicineRepository;
import com.bandtec.mais.consulta.usecase.info.PutMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutMedicineImpl implements PutMedicine {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Optional<Medicine> execute(Integer id, Medicine medicine) {

        if (medicineRepository.existsById(id)) {
            medicine.setMedicineId(id);
            return Optional.of(medicineRepository.save(medicine));
        }

        return Optional.empty();
    }
}
