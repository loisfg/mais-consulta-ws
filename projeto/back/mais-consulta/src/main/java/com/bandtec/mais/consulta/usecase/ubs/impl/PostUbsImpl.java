package com.bandtec.mais.consulta.usecase.ubs.impl;

import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.gateway.repository.UbsRepository;
import com.bandtec.mais.consulta.models.dto.request.UbsPostRequestDTO;
import com.bandtec.mais.consulta.usecase.ubs.PostUbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostUbsImpl implements PostUbs {

    @Autowired
    private UbsRepository ubsRepository;

    @Override
    public Optional<Ubs> execute(UbsPostRequestDTO ubsPostRequestDTO) {
        Ubs ubs = new Ubs();
        ubs.setEndereco(ubsPostRequestDTO.getEndereco());
        ubs.setNome(ubsPostRequestDTO.getNome());
        return Optional.of(ubsRepository.save(ubs));
    }
}
