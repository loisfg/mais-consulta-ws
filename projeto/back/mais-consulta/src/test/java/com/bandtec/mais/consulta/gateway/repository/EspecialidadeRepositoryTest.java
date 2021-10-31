package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class EspecialidadeRepositoryTest {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    private String descricao = StrFormat.toTitledCase("clinico geral");

    //Especialidade
    Especialidade especialidade = Especialidade
            .builder()
            .descricao(descricao)
            .build();

    @Test
    void existsByDescricao() {
        System.out.println(especialidadeRepository.existsByDescricao(descricao));
    }

    @Test
    void findByDescricao() {
        System.out.println(especialidadeRepository.findByDescricao(descricao));
    }
}