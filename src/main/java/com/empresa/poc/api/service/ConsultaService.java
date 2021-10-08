package com.empresa.poc.api.service;

import com.empresa.poc.api.domain.Consulta;
import com.empresa.poc.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    public Consulta save(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public Set<Consulta> findAll(){
        return consultaRepository.findAll();
    }

    public void delete(Integer id) { consultaRepository.deleteById(id); }
}
