package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
}