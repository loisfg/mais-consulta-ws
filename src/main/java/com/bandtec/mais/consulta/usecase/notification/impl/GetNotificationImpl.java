package com.bandtec.mais.consulta.usecase.notification.impl;

import com.bandtec.mais.consulta.domain.Notification;
import com.bandtec.mais.consulta.gateway.repository.NotificationRepository;
import com.bandtec.mais.consulta.models.StackObj;
import com.bandtec.mais.consulta.models.dto.NotificationDTO;
import com.bandtec.mais.consulta.usecase.notification.GetNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GetNotificationImpl implements GetNotification {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Optional<StackObj<NotificationDTO>> execute(Integer userId) {

        List<Notification> notificationList = notificationRepository.findAllByUserId(userId);

        if (notificationList.size() == 0) {
            return Optional.empty();
        }

        List<NotificationDTO> notificationDTOList = new ArrayList<>();
        StackObj<NotificationDTO> notificationStackObj = new StackObj<>(notificationList.size());

        buildListNotificationsDTO(notificationList, notificationDTOList);
        buildStackNotificationDTO(notificationList, notificationDTOList, notificationStackObj);

        return Optional.of(notificationStackObj);
    }

    private void buildListNotificationsDTO(List<Notification> notificationList,
                                           List<NotificationDTO> notificationDTOList) {
        notificationList
                .forEach(notification -> {
                    NotificationDTO newNotificationDTO = new NotificationDTO();

                    newNotificationDTO.setDescription(notification.getDescription());
                    newNotificationDTO.setInsertDateTime(notification.getInsertDateTime());

                    notificationDTOList.add(newNotificationDTO);
                });
    }

    private void buildStackNotificationDTO(List<Notification> notificationList,
                                           List<NotificationDTO> notificationDTOList,
                                           StackObj<NotificationDTO> notificationStackObj) {
        for (int i = 0; i < notificationList.size(); i++) {
            notificationStackObj.push(notificationDTOList.get(i));
        }
    }
}
