package com.bandtec.mais.consulta.usecase.notification.impl;

import com.bandtec.mais.consulta.domain.Notification;
import com.bandtec.mais.consulta.gateway.repository.NotificationRepository;
import com.bandtec.mais.consulta.models.PilhaObj;
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
    public Optional<PilhaObj<NotificationDTO>> execute(Integer idUser) {

        List<Notification> notificationList = notificationRepository.findAllByIdUsuario(idUser);

        if (notificationList.size() == 0){
            return Optional.empty();
        }

        List<NotificationDTO> notificationDTOList = new ArrayList<>();
        PilhaObj<NotificationDTO> notificationPilhaObj = new PilhaObj<>(notificationList.size());

        buildListNotificationsDTO(notificationList, notificationDTOList);
        buildPilhaNotificationDTO(notificationList, notificationDTOList, notificationPilhaObj);

        return Optional.of(notificationPilhaObj);
    }

    private void buildListNotificationsDTO(List<Notification> notificationList, List<NotificationDTO> notificationDTOList) {
        notificationList
                .forEach(notification -> {
                    NotificationDTO newNotificationDTO = new NotificationDTO();

                    newNotificationDTO.setDescription(notification.getDescription());
                    newNotificationDTO.setInsertDateTime(notification.getInsertDateTime());

                    notificationDTOList.add(newNotificationDTO);
                });
    }

    private void buildPilhaNotificationDTO(List<Notification> notificationList, List<NotificationDTO> notificationDTOList, PilhaObj<NotificationDTO> notificationPilhaObj) {
        for (int i = 0; i < notificationList.size(); i++) {
            notificationPilhaObj.push(notificationDTOList.get(i));
        }
    }
}
