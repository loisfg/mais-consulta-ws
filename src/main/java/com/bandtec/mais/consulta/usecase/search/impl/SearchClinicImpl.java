package com.bandtec.mais.consulta.usecase.search.impl;

import com.bandtec.mais.consulta.domain.Clinic;
import com.bandtec.mais.consulta.gateway.repository.ClinicRepository;
import com.bandtec.mais.consulta.usecase.search.SearchClinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchClinicImpl implements SearchClinic {
    @Autowired
    ClinicRepository clinicRepository;

    @Override
    public List<Clinic> execute(Integer id) {
        return clinicRepository.findClinicBySpecialty(id);
    }

    @Override
    public List<Clinic> execute(String district) {
        return clinicRepository.findClinicByDistrict(district);
    }
}
