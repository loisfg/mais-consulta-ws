package com.bandtec.mais.consulta.usecase.search.impl;

import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.gateway.repository.EspecialidadeRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.usecase.search.SearchEspecialidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SearchEspecialidadeImpl implements SearchEspecialidade {
    @Autowired
    EspecialidadeRepository especialidadeRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public Set<Medico> execute(String descricao) {
        Especialidade especialidade = especialidadeRepository.findByDescricao(descricao);

        return medicoRepository.findAllByEspecialidade(especialidade);

        //TODO retirar especialidade do retorno do JSON;
    }
}
