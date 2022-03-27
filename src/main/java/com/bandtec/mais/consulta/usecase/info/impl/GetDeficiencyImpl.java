package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.domain.Deficiency;
import com.bandtec.mais.consulta.gateway.repository.DeficiencyRepository;
import com.bandtec.mais.consulta.usecase.info.GetDeficiency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDeficiencyImpl implements GetDeficiency {

    @Autowired
    private DeficiencyRepository deficiencyRepository;

    @Override
    public List<Deficiency> execute(Integer userId) {
        return deficiencyRepository.findAll();
    }
}
