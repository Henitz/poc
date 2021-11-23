package com.empresa.poc.api.repository;


import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
    List<Paciente> findByAccountAccountId(String accountId);
    Paciente findByIdAndAccountAccountId(Integer id, String accountId);
}
