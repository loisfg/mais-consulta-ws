package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.usecase.auth.MedicoDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoDeleteImpl implements MedicoDelete{
    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public Boolean execute(Integer id) {
        if (medicoRepository.existsById(id)) {
            medicoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
