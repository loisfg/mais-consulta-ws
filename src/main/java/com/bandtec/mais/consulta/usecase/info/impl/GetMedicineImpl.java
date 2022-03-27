package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Medicine;
import com.bandtec.mais.consulta.gateway.repository.MedicineRepository;
import com.bandtec.mais.consulta.usecase.info.GetMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMedicineImpl implements GetMedicine {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Medicine> execute(Integer userId) {
        return medicineRepository.findAll();
    }
}
