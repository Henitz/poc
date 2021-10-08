package com.empresa.poc.api.repository;

import com.empresa.poc.api.domain.Remedio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface RemedioRepository extends CrudRepository<Remedio, Integer> {
    Set<Remedio> findAll();
}
