package com.empresa.poc.api.service;

import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;
    public Medico findById(Integer id) {
        return medicoRepository.findById(id).get();
    }

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }
}
