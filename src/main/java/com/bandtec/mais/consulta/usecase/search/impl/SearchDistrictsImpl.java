package com.bandtec.mais.consulta.usecase.search.impl;

import com.bandtec.mais.consulta.gateway.repository.ClinicRepository;
import com.bandtec.mais.consulta.usecase.search.SearchDistricts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchDistrictsImpl implements SearchDistricts {

    @Autowired
    ClinicRepository clinicRepository;

    @Override
    public List<String> execute() {
        return clinicRepository.findDistrictWithClinic();
    }
}
