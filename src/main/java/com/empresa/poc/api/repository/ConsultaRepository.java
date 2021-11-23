package com.empresa.poc.api.repository;

import com.empresa.poc.api.domain.Consulta;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Remedio;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Integer> {
    List<Consulta> findByAccountAccountId(String accountId);
    Consulta findByIdAndAccountAccountId(Integer id, String accountId);
}
