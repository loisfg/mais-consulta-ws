package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Endereco;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class PacienteRepositoryTest {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void insertAndReceivePacienteCreatedWithBuilder() {
        // Paciente
        final var nome = "Luis";
        final var telefone = "";
        final var dtNascimento = LocalDate.of(1998, 3, 31);
        final var sexo = "Masculino";
        final var numeroCarteiraSus = "0930219312";

        // Endereço
        final var cep = "06550150";
        final var cidade = "Taboão da Serra";
        final var estado = "SP";
        final var bairro = "Jardim Iracema";
        final var logradouro = "";
        final var numero = "313";
        final var complemento = "";
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

        //Usuario
        final var cpf = "40132321-x";
        final var email = "";
        final var password = "";
        Usuario usuario = Usuario
                .builder()
                .setCpf(cpf)
                .setEmail(email)
                .setPassword(password)
                .build();

        Paciente paciente = Paciente
                .builder()
                .setName(nome)
                .setDtNascimento(dtNascimento)
                .setTelefone(telefone)
                .setSexo(sexo)
                .setNumeroCarteiraSus(numeroCarteiraSus)
                .setEndereco(endereco)
                .setUsuario(usuario)
                .build();

        pacienteRepository.save(paciente);

        Paciente pacienteResult = pacienteRepository.findByNome("Luis");

        System.out.println(pacienteResult.toString());

        assertThat("Paciente criado com todas info", pacienteRepository.existsByNome(nome));
//        assertThat("Paciente criado com ligação em endereço", false); // falta ligação de paciente x endereço
        assertThat("Paciente criado com um usuário", usuarioRepository.existsByCpf(cpf));
    }
}