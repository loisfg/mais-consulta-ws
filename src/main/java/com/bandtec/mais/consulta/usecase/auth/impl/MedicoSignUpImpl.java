package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Medico;
import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.domain.Usuario;
import com.bandtec.mais.consulta.gateway.repository.EspecialidadeRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.UbsRepository;
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

    @Autowired
    private UbsRepository ubsRepository;

    @Override
    public Optional<Usuario> execute(MedicoSignUpRequestDTO medicoSignUpRequestDTO) {
        Medico medico = medicoSignUpRequestDTO.getMedico();
        Usuario usuario = MedicoSignUpRequestDTO.convertFromController(medicoSignUpRequestDTO);
        Optional<Ubs> ubs = ubsRepository.findById(medicoSignUpRequestDTO.getIdUbs());

        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            log.info("Usuario já existente");
            return Optional.empty();
        } else {
            if (especialidadeRepository.existsByDescricao(medico.getEspecialidade().getDescricao())) {
                medico.setEspecialidade(especialidadeRepository.findByDescricao(medico.getEspecialidade().getDescricao()));
            }
            ubs.ifPresent(medico::setUbs);
            medico.setUsuario(usuario);
            medicoRepository.save(medico);

            return Optional.of(usuarioRepository.save(usuario));
        }
    }

}
