package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@SpringBootTest
class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository medicoRepository;

    @Test
   void insertAndReceiveMedicoCreatedWithBuilder() {
        //usuario
        final String cpf = "49575413885-x";
        final String email = "JoaoFernandes@outlock.com.br";
        final String password = "123";
        Usuario usuario = Usuario
                .builder()
                .cpf(cpf)
                .email(email)
                .password(password)
                .build();

        // especialidade
        final String descricao = StrFormat.toTitledCase("oftalmologia");

        Especialidade especialidade = Especialidade
                .builder()
                .descricao(descricao)
                .build();

        // Medico
        final String nome = StrFormat.toTitledCase("Joao Fernandes");
        Medico medico = Medico.builder()
                .usuario(usuario)
                .nome(nome)
                .especialidade(especialidade)
                .build();

        medicoRepository.save(medico);

        if (medicoRepository.existsByNome(nome)){
            System.out.println("Medico existe" + medicoRepository.findByNome(nome));
        }
        System.out.println("Medico repository teste "+ medicoRepository.findIdsMedicosByIdEspecialidade(1));
    }
}
