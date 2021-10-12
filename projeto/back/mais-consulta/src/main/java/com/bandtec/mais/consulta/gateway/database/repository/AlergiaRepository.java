package com.bandtec.mais.consulta.gateway.database.repository;

import com.bandtec.mais.consulta.domain.Alergia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlergiaRepository extends JpaRepository<Alergia, Integer> {

}
