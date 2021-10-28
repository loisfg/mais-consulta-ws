package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Especialidade;
import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Usuario;
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

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Test
   void insertAndReceiveMedicoCreatedWithBuilder() {
        // Medico
        final String nome = "Joao Fernandes";
        //usuario
        final String cpf = "49575413885-x";
        final String email = "JoaoFernandes@outlock.com.br";
        final String password = "123";
        Usuario usuario = Usuario
                .builder()
                .setCpf(cpf)
                .setEmail(email)
                .setPassword(password)
                .build();

        // especialidade
        final String descrição = "oftalmologia";

        Especialidade especialidade = Especialidade
                .builder()
                .setDescricao(descrição)
                .build();

        especialidadeRepository.save(especialidade);

//       especialidade if (especialidadeRepository.existsByDescricao(descrição)) {
//            System.out.printf("especialidade existe", especialidadeRepository.existsByDescricao(descrição));
//        }
        System.out.println(especialidade);
        Especialidade optionalEspecialidade = especialidadeRepository.findByDescricao(descrição);
        Medico medico = Medico
                .builder()
                .setUsuario(usuario)
                .setNome(nome)
                .setEspecialidade(optionalEspecialidade)
                .build();

        medicoRepository.save(medico);

        if (medicoRepository.existsByNome(nome)){
            System.out.printf("Medico existe", medicoRepository.existsByNome(nome));
        }

    }




}
