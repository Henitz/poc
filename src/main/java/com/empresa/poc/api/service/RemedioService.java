package com.empresa.poc.api.service;

import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Remedio;
import com.empresa.poc.api.repository.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemedioService {
    @Autowired
    RemedioRepository remedioRepository;

    public Remedio save(Remedio remedio) {return remedioRepository.save(remedio);}

    public Remedio findById(Integer id) {
        return remedioRepository.findById(id).get();
    }

    public List<Remedio> findAll(){

        return (List<Remedio>) remedioRepository.findAll();
    }

    public Remedio deleteById(Integer id) {

        remedioRepository.deleteById(id);
        return new Remedio();
    }

    public List<Remedio> findByAccountId(String accountId) {

        return  remedioRepository.findByAccountAccountId(accountId);
    }
    public Remedio findByIdAndAccountAccountId(Integer id, String accountId) {
        return  remedioRepository.findByIdAndAccountAccountId(id, accountId);
    }

    public void deleteByAccountId(Integer id, String accountId) {
        remedioRepository.deleteById(id);
    }

}
