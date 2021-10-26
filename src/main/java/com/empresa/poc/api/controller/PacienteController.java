package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.controller.dto.PacienteDto;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Paciente;
import com.empresa.poc.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public PacienteDto save(@RequestBody PacienteDto dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setPlanoDeSaude(dto.getPlanoDeSaude());


        Paciente pacienteReturn = pacienteService.save(paciente);
        PacienteDto dtoReturn = new PacienteDto();
        dtoReturn.setId(pacienteReturn.getId());
        dtoReturn.setNome(pacienteReturn.getNome());
        dtoReturn.setPlanoDeSaude(pacienteReturn.getPlanoDeSaude());

        return dtoReturn;
    }

    @GetMapping("/{id}")
    public PacienteDto getOne(@PathVariable Integer id){

        Paciente saved = pacienteService.findById(id);

        PacienteDto dto = new PacienteDto();
        dto.setId(saved.getId());
        dto.setNome(saved.getNome());
        dto.setPlanoDeSaude(saved.getPlanoDeSaude());

        return dto;
    }

    @GetMapping
    public List<PacienteDto> todos() {

        List<Paciente> pacientes = pacienteService.findAll();
        List<PacienteDto> pacientesDto = new ArrayList<>();

        for (Paciente paciente : pacientes) {

            PacienteDto pacienteDto = new PacienteDto();
            pacienteDto.setId(paciente.getId());
            pacienteDto.setNome(paciente.getNome());
            pacienteDto.setPlanoDeSaude(paciente.getPlanoDeSaude());

            pacientesDto.add(pacienteDto);

        }

        return pacientesDto;
    }

    @DeleteMapping("/{id}")
    public PacienteDto delete(@PathVariable Integer id) {

        pacienteService.deleteById(id);

        return new PacienteDto();

    }

}