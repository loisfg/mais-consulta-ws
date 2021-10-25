package com.bandtec.mais.consulta.gateway.repository;

import com.bandtec.mais.consulta.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {
    boolean existsByCep(String nome);
}
