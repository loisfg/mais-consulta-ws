package com.bandtec.mais.consulta.usecase.notification.impl;

import com.bandtec.mais.consulta.domain.Agendamento;
import com.bandtec.mais.consulta.domain.Notification;
import com.bandtec.mais.consulta.factory.NotificationAdapter;
import com.bandtec.mais.consulta.factory.NotificationFactory;
import com.bandtec.mais.consulta.gateway.repository.NotificationRepository;
import com.bandtec.mais.consulta.usecase.notification.CreateNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateNotificationImpl implements CreateNotification {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationFactory notificationFactory;

    @Override
    public void execute(Agendamento agendamento, String type) {

        NotificationAdapter notificationMessageService = notificationFactory.getNotificationAdapter(type);
        String descricaoNotification = notificationMessageService.buildNotificationMessage(agendamento);

        Notification notification = new Notification();

        notification.setDescricao(descricaoNotification);
        notification.setIdUsuario(agendamento.getPaciente().getUsuario().getIdUsuario());
        notification.setInsertDt(LocalDateTime.now());

        notificationRepository.save(notification);
    }
}
