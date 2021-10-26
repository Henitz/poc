package com.empresa.poc.api.service;

import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Paciente;
import com.empresa.poc.api.repository.MedicoRepository;
import com.empresa.poc.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public Paciente findById(Integer id) {
        return pacienteRepository.findById(id).get();
    }

    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> findAll() {

        return (List<Paciente>) pacienteRepository.findAll();
    }

    public Paciente deleteById(Integer id) {

        pacienteRepository.deleteById(id);
        return new Paciente();
    }
}