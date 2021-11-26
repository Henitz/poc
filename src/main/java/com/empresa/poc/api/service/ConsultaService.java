package com.empresa.poc.api.service;

import com.empresa.poc.api.domain.Consulta;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    public Consulta save(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public Consulta findByIdAndAccountId(Integer id, String accountId) {
        return consultaRepository.findByIdAndAccountAccountId(id, accountId);
    }

    public List<Consulta> findAll(){

        return (List<Consulta>) consultaRepository.findAll();
    }

    public Consulta deleteById(Integer id) {

        consultaRepository.deleteById(id);
        return new Consulta();
    }
    public List<Consulta> findByAccountId(String accountId) {

        return  consultaRepository.findByAccountAccountId(accountId);
    }

    public Consulta findByIdAndAccountAccountId(Integer id, String accountId) {
        return  consultaRepository.findByIdAndAccountAccountId(id, accountId);
    }
}
