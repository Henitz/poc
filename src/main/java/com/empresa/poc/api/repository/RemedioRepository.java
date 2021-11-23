package com.empresa.poc.api.repository;

import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Remedio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RemedioRepository extends CrudRepository<Remedio, Integer> {
    List<Remedio> findByAccountAccountId(String accountId);
    Remedio findByIdAndAccountAccountId(Integer id, String accountId);
}
