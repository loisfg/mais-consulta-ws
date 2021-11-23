package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.*;
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
        Endereco endereco = Endereco.builder()
                .cep("aaa")
                .cidade("dcsdas")
                .estado("sp")
                .bairro("xxx")
                .rua("werty")
                .logradouro("daw")
                .numero("333")
                .complemento("dfsd")
                .build();

        Especialidade especialidade = Especialidade
                .builder()
                .descricao(descricao)
                .build();

        Ubs ubs = Ubs.builder()
                .nome("wert")
                .telefone("2345678")
                .endereco(endereco)
                .build();
        // Medico
        final String nome = StrFormat.toTitledCase("Joao Fernandes");
        Medico medico = Medico.builder()
                .nome(nome)
                .ubs(ubs)
                .usuario(usuario)
                .especialidade(especialidade)
                .build();

        medicoRepository.save(medico);

        if (medicoRepository.existsByNome(nome)){
            System.out.println("Medico existe" + medicoRepository.findByNome(nome));
        }
        System.out.println("Medico repository teste "+ medicoRepository.findIdsMedicosByIdEspecialidade(1,1));
    }
}
