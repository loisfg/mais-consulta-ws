package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Endereco;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class PacienteRepositoryTest {
    // Endereço
    final String cep = "06550150";
    final String cidade = "Taboão da Serra";
    final String estado = "SP";
    final String bairro = "Jardim Iracema";
    final String logradouro = "";
    final String numero = "313";
    final String complemento = "";
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
    final String cpf = "40132321-x";
    final String email = "luis@outlock.com.br";
    final String password = "123";
    Usuario usuario = Usuario
            .builder()
            .setCpf(cpf)
            .setEmail(email)
            .setPassword(password)
            .build();

    // Paciente
    final String nome = "Luis";
    final String telefone = "";
    final LocalDate dtNascimento = LocalDate.of(1998, 3, 31);
    final String sexo = "Masculino";
    final String numeroCarteiraSus = "0930219312";
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

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    private static void accept(Usuario value) {
        System.out.printf("\nUsuário criado: %s\n", value);
    }

    private static void accept(Endereco value) {
        System.out.printf("\nEndereço criado com sucesso! %s\n", value);
    }

    private static void accept(Paciente value) {
        System.out.printf("\nPaciente logado: %s\n", value);
    }

    @Test
    void patientUser() {
        pacienteRepository.save(paciente);

        Optional<Paciente> optionalPaciente = pacienteRepository.findById(paciente.getIdPaciente());

        optionalPaciente.ifPresent(PacienteRepositoryTest::accept);
        assertThat("Paciente completamente criado", pacienteRepository.existsById(paciente.getIdPaciente()));
    }

    @Test
    void loginUser() {
        usuarioRepository.save(usuario);

        Optional<Usuario> oUsuario = usuarioRepository.findByCpfAndPassword(cpf, password);

        oUsuario.ifPresent(PacienteRepositoryTest::accept);
        assertThat("Paciente criado com um usuário", usuarioRepository.existsByCpf(paciente.getUsuario().getCpf()));
    }

    @Test
    void adressUser() {
        enderecoRepository.save(endereco);

        Optional<Endereco> oEndereco = enderecoRepository.findById(paciente.getEndereco().getIdEndereco());

        oEndereco.ifPresent(PacienteRepositoryTest::accept);
        assertThat("Paciente criado com ligação em endereço", enderecoRepository.existsById(endereco.getIdEndereco()));
    }

    @Test
    void allPatientUser() {
        pacienteRepository.save(paciente);

        Iterable<Paciente> list = pacienteRepository.findAll();

        for (Paciente paciente : list) {
            System.out.println(paciente);
        }
    }
}