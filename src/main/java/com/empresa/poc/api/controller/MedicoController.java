package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @PostMapping("/medicos")
    public MedicoDto save(@RequestBody MedicoDto dto){

        Medico medico = medicoService.save(new Medico(dto.getNome()));

        return new MedicoDto(medico.getId(), medico.getNome());
    }
}
