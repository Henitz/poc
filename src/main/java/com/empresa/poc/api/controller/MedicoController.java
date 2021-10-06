package com.empresa.poc.api.controller;

import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.repository.MedicoRepository;
import com.empresa.poc.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @PostMapping
    public Medico save(@RequestBody Medico medico){
        return medicoService.save(medico);
    }
}
