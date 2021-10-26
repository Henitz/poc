package com.empresa.poc.api.controller;


import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.controller.dto.PacienteDto;
import com.empresa.poc.api.controller.dto.RemedioDto;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Paciente;
import com.empresa.poc.api.domain.Remedio;
import com.empresa.poc.api.service.PacienteService;
import com.empresa.poc.api.service.RemedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/remedios")
@CrossOrigin("*")
public class RemedioController {

    @Autowired
    RemedioService remedioService;

    @PostMapping
    public RemedioDto save(@RequestBody RemedioDto dto) {
        Remedio remedio = new Remedio();
        remedio.setNome(dto.getNome());

        Remedio remedioReturn = remedioService.save(remedio);
        RemedioDto dtoReturn = new RemedioDto();
        dtoReturn.setId(remedioReturn.getId());
        dtoReturn.setNome(remedioReturn.getNome());

        return dtoReturn;
    }
    @GetMapping("/{id}")
    public RemedioDto one(@PathVariable Integer id) {

        Remedio saved = remedioService.findById(id);

        RemedioDto dto = new RemedioDto();
        dto.setId(saved.getId());
        dto.setNome(saved.getNome());

        return dto;
    }

    @GetMapping
    public List<RemedioDto> todos() {

        List<Remedio> remedios = remedioService.findAll();
        List<RemedioDto> remediosDto = new ArrayList<>();

        for (Remedio remedio : remedios) {

            RemedioDto remedioDto = new RemedioDto();
            remedioDto.setId(remedio.getId());
            remedioDto.setNome(remedio.getNome());


            remediosDto.add(remedioDto);

        }

        return remediosDto;
    }
}
