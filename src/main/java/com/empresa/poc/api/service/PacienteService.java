package com.empresa.poc.api.service;

import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Paciente;
import com.empresa.poc.api.repository.MedicoRepository;
import com.empresa.poc.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    }


}
