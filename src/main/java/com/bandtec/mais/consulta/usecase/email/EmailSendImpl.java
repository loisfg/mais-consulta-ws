package com.bandtec.mais.consulta.usecase.email;


import com.bandtec.mais.consulta.domain.Email;
import com.bandtec.mais.consulta.domain.Paciente;
import com.bandtec.mais.consulta.gateway.repository.EmailRepository;
import com.bandtec.mais.consulta.gateway.repository.PacienteRepository;
import com.bandtec.mais.consulta.models.dto.request.EmailDTO;
import com.bandtec.mais.consulta.models.enums.StatusEmail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmailSendImpl implements EmailSend {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Email execute(EmailDTO emailDTO, Integer id) {
        Email email = new Email();
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        paciente.ifPresent(value -> emailDTO.setEmailTo(value.getUsuario().getEmail()));
        BeanUtils.copyProperties(emailDTO, email);
        email.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            return emailRepository.save(email);
        }
    }
}
