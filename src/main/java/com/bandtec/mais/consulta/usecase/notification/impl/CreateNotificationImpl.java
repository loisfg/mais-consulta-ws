package com.bandtec.mais.consulta.usecase.notification.impl;

import com.bandtec.mais.consulta.domain.Scheduling;
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
    public void execute(Scheduling scheduling, String consult) {

        NotificationAdapter notificationMessageService = notificationFactory.getNotificationAdapter(consult);
        String notificationDescription = notificationMessageService.buildNotificationMessage(scheduling);

        Notification notification = new Notification();

        notification.setDescription(notificationDescription);
        notification.setUserId(scheduling.getPatient().getUser().getUserId());
        notification.setInsertDateTime(LocalDateTime.now());

        notificationRepository.save(notification);
    }
}
