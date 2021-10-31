package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Alergia;
import com.bandtec.mais.consulta.domain.Endereco;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.utils.StrFormat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class PacienteRepositoryTest {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Endereço
    final String cep = "06550150";
    final String cidade = StrFormat.toTitledCase("Taboão da Serra");
    final String estado = "SP".toUpperCase();
    final String bairro = StrFormat.toTitledCase("Jardim Iracema");
    final String logradouro = "";
    final String numero = "313";
    final String complemento = "";
    Endereco endereco = Endereco
            .builder()
            .cep(cep)
            .cidade(cidade)
            .estado(estado)
            .bairro(bairro)
            .logradouro(logradouro)
            .numero(numero)
            .complemento(complemento)
            .build();

    //Usuario
    final String cpf = "40132321-x";
    final String email = "luis@outlock.com.br";
    final String password = "123";
    Usuario usuario = Usuario
            .builder()
            .cpf(cpf)
            .email(email)
            .password(password)
            .build();

    //Alergia
    Alergia alergia1 = Alergia
            .builder()
            .nome("formiga")
            .build();

    Alergia alergia2 = Alergia
            .builder()
            .nome("poeira")
            .build();

    // Paciente
    final String nome = "Luis";
    final String telefone = "";
    final LocalDate dtNascimento = LocalDate.of(1998, 3, 31);
    final String sexo = "Masculino";
    final String numeroCarteiraSus = "0930219312";
    Paciente paciente = Paciente
            .builder()
            .nome(nome)
            .dtNascimento(dtNascimento)
            .telefone(telefone)
            .sexo(sexo)
            .numeroCarteiraSus(numeroCarteiraSus)
            .endereco(endereco)
            .alergias(Set.of())
            .doencas(Set.of())
            .remedios(Set.of())
            .deficiencias(Set.of())
            .usuario(usuario)
            .build();

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
        pacienteRepository.save(paciente);
        Optional<Paciente> pacientes = pacienteRepository.findByUsuarioCpfAndUsuarioPassword(cpf, password);

        pacientes.ifPresent(PacienteRepositoryTest::accept);
        assertThat("Paciente criado com um usuário", pacienteRepository.existsByUsuarioCpf(paciente.getUsuario().getCpf()));
    }

    @Test
    void adressUser() {
        List<Paciente> pacientes = pacienteRepository.findByEnderecoBairro(paciente.getEndereco().getBairro());

        pacientes.stream().findFirst().ifPresent(PacienteRepositoryTest::accept);
        assertThat("Paciente criado com ligação em endereço", pacienteRepository.existsByEnderecoCidade(endereco.getCidade()));
    }

    @Test
    void allPatientUser() {
        pacienteRepository.save(paciente);

        List<Paciente> list = pacienteRepository.findAll();

        System.out.println("Todos pacientes: " + list);
    }

    @Test
    void allPatientContaing() {
        List<Paciente> list = pacienteRepository.findByNomeContaining("Luis");

        System.out.println("Pacientes com nome Luis" + list);
    }

    @Test
    void allPatientBairro() {
        List<Paciente> list = pacienteRepository.findByEnderecoBairro(bairro);

        System.out.println("pacientes no bairro" + list);
    }
}