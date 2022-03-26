package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Address, Integer> {
}
