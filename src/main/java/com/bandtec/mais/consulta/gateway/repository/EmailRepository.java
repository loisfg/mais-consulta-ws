package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
