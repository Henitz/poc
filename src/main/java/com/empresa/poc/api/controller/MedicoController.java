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

        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());

        Medico medicoReturn = medicoService.save(medico);
        MedicoDto dtoReturn = new MedicoDto();
        dtoReturn.setNome(medicoReturn.getNome());
        dtoReturn.setEspecialidade(medicoReturn.getEspecialidade());

        return dtoReturn;
    }
}
