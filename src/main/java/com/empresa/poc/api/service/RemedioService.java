package com.empresa.poc.api.service;

import com.empresa.poc.api.domain.Remedio;
import com.empresa.poc.api.repository.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemedioService {
    @Autowired
    RemedioRepository remedioRepository;

    public Remedio save(Remedio remedio) {return remedioRepository.save(remedio);}
}