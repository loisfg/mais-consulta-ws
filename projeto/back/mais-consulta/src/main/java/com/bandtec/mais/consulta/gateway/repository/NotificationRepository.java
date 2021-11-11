package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    List<Notification> findAllByIdUsuario();
}
