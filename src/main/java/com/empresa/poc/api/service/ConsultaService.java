package com.empresa.poc.api.service;

import com.empresa.poc.api.domain.Consulta;
import com.empresa.poc.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    public Consulta save(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public Consulta findById(Integer id) {
        return consultaRepository.findById(id).get();
    }
}
