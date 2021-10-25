package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.gateway.repository.AlergiaRepository;
import com.bandtec.mais.consulta.models.ListaObj;
import com.bandtec.mais.consulta.usecase.info.GetAlergia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAlergiaImpl implements GetAlergia {

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Override
    public ListaObj<Alergia> execute(Integer idUser) {

        int size = (int) alergiaRepository.count();

        ListaObj<Alergia> alergiaListObj = new ListaObj<>(size);
        List<Alergia> alergiaList = alergiaRepository.findAll();

        alergiaList.forEach(alergiaListObj::adiciona);

        return alergiaListObj;
    }
}
