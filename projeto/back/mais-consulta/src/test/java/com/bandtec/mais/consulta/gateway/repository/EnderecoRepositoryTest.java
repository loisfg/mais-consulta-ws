package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Endereco;
import com.bandtec.mais.consulta.domain.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
@SpringBootTest
class EnderecoRepositoryTest {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Test
    void  insertAndReceiveEnderecoCreatedWithBuilder(){
        //endereço
        final var cep = "04466025";
        final var cidade = "são paulo";
        final var estado = "são paulo";
        final var bairro = "bairro X";
        final var logradouro = "89";
        final var numero = "234";
        final var complemento = "188b";

        Endereco endereco = Endereco
                .builder()
                .setCep(cep)
                .setCidade(cidade)
                .setEstado(estado)
                .setBairro(bairro)
                .setLogradouro(logradouro)
                .setNumero(numero)
                .setComplemento(complemento)
                .build();

        enderecoRepository.save(endereco);

        assertThat("Endereço criado com sucesso",enderecoRepository.existsByCep(cep));

        Optional<Endereco> optionalEndereco = enderecoRepository.findById(endereco.getIdEndereco());
        System.out.println(optionalEndereco);
    }
}
