package com.bandtec.mais.consulta.usecase.search.impl;

import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.gateway.repository.UbsRepository;
import com.bandtec.mais.consulta.usecase.search.SearchUbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchUbsImpl implements SearchUbs {

    @Autowired
    UbsRepository ubsRepository;

    @Override
    public List<Ubs> execute() {
        return ubsRepository.findAll();
    }
}
