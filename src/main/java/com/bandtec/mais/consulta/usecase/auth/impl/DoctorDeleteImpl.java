package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.gateway.repository.DoctorRepository;
import com.bandtec.mais.consulta.usecase.auth.DoctorDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorDeleteImpl implements DoctorDelete {
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Boolean execute(Integer id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
