package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.controller.dto.PacienteDto;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Paciente;
import com.empresa.poc.api.service.MedicoService;
import com.empresa.poc.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public PacienteDto save(@RequestBody PacienteDto dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setPlanodesaude(dto.getPlanodesaude());


        Paciente pacienteReturn = pacienteService.save(paciente);
        PacienteDto dtoReturn = new PacienteDto();
        dtoReturn.setId(pacienteReturn.getId());
        dtoReturn.setNome(pacienteReturn.getNome());
        dtoReturn.setPlanodesaude(pacienteReturn.getPlanodesaude());

        return dtoReturn;
    }

    @GetMapping("/{id}")
    public PacienteDto getOne(@PathVariable Integer id){

        Paciente saved = pacienteService.findById(id);

        PacienteDto dto = new PacienteDto();
        dto.setNome(saved.getNome());
        dto.setPlanodesaude(saved.getPlanodesaude());

        return dto;
    }
}