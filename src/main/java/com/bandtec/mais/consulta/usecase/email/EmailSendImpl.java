package com.bandtec.mais.consulta.usecase.email;


import com.bandtec.mais.consulta.domain.Email;
import com.bandtec.mais.consulta.domain.Patient;
import com.bandtec.mais.consulta.gateway.repository.EmailRepository;
import com.bandtec.mais.consulta.gateway.repository.PatientRepository;
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
    private PatientRepository patientRepository;

    @Override
    public Email execute(EmailDTO emailDTO, Integer id) {
        Email email = new Email();
        Optional<Patient> patient = patientRepository.findById(id);
        patient.ifPresent(value -> emailDTO.setEmailTo(value.getUser().getEmail()));
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
