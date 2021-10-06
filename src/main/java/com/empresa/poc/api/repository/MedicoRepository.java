package com.empresa.poc.api.repository;

import com.empresa.poc.api.domain.Medico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Integer> {
}
