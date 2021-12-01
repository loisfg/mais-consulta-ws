package com.bandtec.mais.consulta.usecase.info.impl;

import com.bandtec.mais.consulta.gateway.repository.DoencaRepository;
import com.bandtec.mais.consulta.models.dto.response.InfoResponseDTO;
import com.bandtec.mais.consulta.usecase.info.GetDstToComplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class GetDstToCompletImpl implements GetDstToComplet {

    @Autowired
    DoencaRepository doencaRepository;

    @Override
    public Optional<Set<InfoResponseDTO>> execute(String nome) {
        return doencaRepository.findDoencaByNomeStartingWithIgnoreCaseAndDst(nome);
    }
}
