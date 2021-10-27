package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.repository.EspecialidadeRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.MedicoSignUpRequestDTO;
import com.bandtec.mais.consulta.usecase.auth.MedicoSignUp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MedicoSignUpImpl implements MedicoSignUp {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Override
    public Optional<Usuario> execute(MedicoSignUpRequestDTO medicoSignUpRequestDTO) {
        Medico medico = medicoSignUpRequestDTO.getMedico();
        Usuario usuario = MedicoSignUpRequestDTO.convertFromController(medicoSignUpRequestDTO);

        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            log.info("Usuario já existente");
            return Optional.empty();
        } else {
            boolean existsEspecialidade = especialidadeRepository.existsByDescricao(medico.getEspecialidade().getDescricao());
            if (existsEspecialidade) {
                medico.setEspecialidade(especialidadeRepository.findByDescricao(medico.getEspecialidade().getDescricao()));
            }
            medico.setUsuario(usuario);
            medicoRepository.save(medico);
            log.info("Medico criado com sucesso {}", medico);
            return Optional.of(usuarioRepository.save(usuario));
        }
    }

}
