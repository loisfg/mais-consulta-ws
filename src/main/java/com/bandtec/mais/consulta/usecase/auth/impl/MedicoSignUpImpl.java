package com.bandtec.mais.consulta.usecase.auth.impl;

import com.bandtec.mais.consulta.domain.Doctor;
import com.bandtec.mais.consulta.domain.Ubs;
import com.bandtec.mais.consulta.domain.User;
import com.bandtec.mais.consulta.gateway.repository.EspecialidadeRepository;
import com.bandtec.mais.consulta.gateway.repository.MedicoRepository;
import com.bandtec.mais.consulta.gateway.repository.UbsRepository;
import com.bandtec.mais.consulta.gateway.repository.UsuarioRepository;
import com.bandtec.mais.consulta.models.dto.request.SignUpDoctorRequestDTO;
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
    public Optional<User> execute(SignUpDoctorRequestDTO signUpDoctorRequestDTO) {
        Doctor doctor = signUpDoctorRequestDTO.getDoctor();
        User user = SignUpDoctorRequestDTO.convertFromController(signUpDoctorRequestDTO);
        Optional<Ubs> ubs = ubsRepository.findById(signUpDoctorRequestDTO.getUbsId());

        if (usuarioRepository.existsByCpf(user.getCpf())) {
            log.info("Usuario já existente");
            return Optional.empty();
        } else {
            if (especialidadeRepository.existsByDescricao(doctor.getSpecialty().getDescription())) {
                doctor.setSpecialty(especialidadeRepository.findByDescricao(doctor.getSpecialty().getDescription()));
            }
            ubs.ifPresent(doctor::setUbs);
            doctor.setUser(user);
            medicoRepository.save(doctor);

            return Optional.of(usuarioRepository.save(user));
        }
    }

}
