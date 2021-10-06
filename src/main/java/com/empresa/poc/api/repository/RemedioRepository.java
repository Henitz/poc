package com.empresa.poc.api.repository;

import com.empresa.poc.api.domain.Remedio;
import org.springframework.data.repository.CrudRepository;

public interface RemedioRepository extends CrudRepository<Remedio, Integer> {
}
