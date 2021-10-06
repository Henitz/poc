package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.MedicoDto;
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

    @PostMapping("/medicos")
    public MedicoDto save(@RequestBody MedicoDto dto){

        Medico medico = medicoService.save(new Medico(dto.getNome()));

        return new MedicoDto(medico.getNome());
    }
}
