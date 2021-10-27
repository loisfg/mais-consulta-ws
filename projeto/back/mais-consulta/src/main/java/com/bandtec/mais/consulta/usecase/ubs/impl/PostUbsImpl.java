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
        if (ubsRepository.existsByNome(ubsPostRequestDTO.getNome())) {
            return ubsRepository.findUbsByNome(ubsPostRequestDTO.getNome());
        }

        Ubs ubs = UbsPostRequestDTO.convertFromController(ubsPostRequestDTO);
        return Optional.of(ubsRepository.save(ubs));
    }
}
