package com.empresa.poc.api.repository;

import com.empresa.poc.api.domain.Consulta;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {
}
