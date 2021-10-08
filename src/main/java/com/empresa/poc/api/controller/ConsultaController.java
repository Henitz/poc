package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.ConsultaDto;
import com.empresa.poc.api.controller.dto.RemedioDto;
import com.empresa.poc.api.domain.Consulta;
import com.empresa.poc.api.domain.Remedio;
import com.empresa.poc.api.repository.ConsultaRepository;
import com.empresa.poc.api.repository.RemedioRepository;
import com.empresa.poc.api.service.ConsultaService;
import com.empresa.poc.api.service.RemedioService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    Logger logger = LoggerFactory.getLogger(ConsultaController.class);

    @Autowired
    ConsultaService consultaService;

    @Autowired
    RemedioService remedioService;

    @PostMapping
    public ConsultaDto create(@RequestBody Consulta consulta){
        Set<Remedio> remedios = new HashSet<>();
        for(Remedio r : consulta.getRemedios()){
            Optional<Remedio> optionalRemedio = remedioService.findById(r.getId());
            if (!optionalRemedio.isPresent()) {
                return new ConsultaDto();
            }
            remedios.add(optionalRemedio.get());
        }
        consulta.setRemedios(remedios);

        Consulta saved = consultaService.save(consulta);

        return toDto(saved);
    }

    @GetMapping
    public Set<ConsultaDto> getAll(){
        Set<Consulta> consultas = consultaService.findAll();


        for(Consulta c : consultas){
            Set<Remedio> remedios = new HashSet<>();
            for (Remedio r : c.getRemedios()){
                Optional<Remedio> optionalRemedio = remedioService.findById(r.getId());
                remedios.add(optionalRemedio.get());
            }
            c.setRemedios(remedios);
            consultas.add(c);
        }

        return toSetDto(consultas);
    }

    private ConsultaDto toDto(Consulta consulta){

        Set<RemedioDto> remediosDto = new HashSet<>();
        ConsultaDto consultaDto = new ConsultaDto();

        for(Remedio r : consulta.getRemedios()){
            RemedioDto rDto = new RemedioDto();
            rDto.setId(r.getId());
            rDto.setNome(r.getNome());
            remediosDto.add(rDto);
        }
        consultaDto.setRemedios(remediosDto);
        consultaDto.setId(consulta.getId());
        return consultaDto;
    }

    private Set<ConsultaDto> toSetDto(Set<Consulta> consultas) {

        Set<ConsultaDto> consultasDto = new HashSet<>();
        for(Consulta c : consultas){
            consultasDto.add(toDto(c));
        }
        return consultasDto;
    }
}
