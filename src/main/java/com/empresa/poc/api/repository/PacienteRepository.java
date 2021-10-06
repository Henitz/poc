package com.empresa.poc.api.repository;


import com.empresa.poc.api.domain.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
}
