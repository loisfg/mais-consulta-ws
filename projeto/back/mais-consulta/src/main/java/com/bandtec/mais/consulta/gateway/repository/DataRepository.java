package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Data;
import com.bandtec.mais.consulta.domain.Hora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Set;

public interface DataRepository extends JpaRepository<Data, Integer> {
}