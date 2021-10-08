package com.empresa.poc.api.repository;

import com.empresa.poc.api.domain.Consulta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {
    Set<Consulta> findAll();
}
