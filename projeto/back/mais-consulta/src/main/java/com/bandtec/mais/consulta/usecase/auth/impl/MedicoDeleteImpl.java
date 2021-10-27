package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.exception.DeleteException;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.usecase.auth.MedicoDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class MedicoDeleteImpl implements MedicoDelete{
    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public ResponseEntity<?> execute(Integer id) throws DeleteException {
//        medicoRepository.findById(id).ifPresentOrElse(medicoRepository.deleteById(id),);
        return ResponseEntity.ok().build();
    }
}
