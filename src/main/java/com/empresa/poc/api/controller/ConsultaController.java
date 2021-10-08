package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.ConsultaDto;
import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.controller.dto.PacienteDto;
import com.empresa.poc.api.controller.dto.RemedioDto;
import com.empresa.poc.api.domain.Consulta;
import com.empresa.poc.api.domain.Remedio;
import com.empresa.poc.api.service.ConsultaService;
import com.empresa.poc.api.service.MedicoService;
import com.empresa.poc.api.service.PacienteService;
import com.empresa.poc.api.service.RemedioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    Logger logger = LoggerFactory.getLogger(ConsultaController.class);

    @Autowired
    ConsultaService consultaService;

    @Autowired
    RemedioService remedioService;

    @Autowired
    MedicoService medicoService;

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ConsultaDto create(@RequestBody Consulta consulta){
        consulta.setRemedios(getRemedioSet(consulta));

        Consulta saved = consultaService.save(consulta);
        saved.setMedico(medicoService.findById(saved.getMedico().getId()));
        saved.setPaciente(pacienteService.findById(saved.getPaciente().getId()));

        return toDto(saved);
    }

    @GetMapping
    public Set<ConsultaDto> getAll(){
        Set<Consulta> consultas = consultaService.findAll();
        for(Consulta c : consultas){
            c.setRemedios(getRemedioSet(c));
            consultas.add(c);
        }

        return toSetDto(consultas);
    }

    private Set<Remedio> getRemedioSet(Consulta c) {
        Set<Remedio> remedios = new HashSet<>();
        for (Remedio r : c.getRemedios()){
            Optional<Remedio> optionalRemedio = remedioService.findById(r.getId());
            if (!optionalRemedio.isPresent()) {
                return new HashSet<>();
            }
            remedios.add(optionalRemedio.get());
        }
        return remedios;
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
        consultaDto.setId(consulta.getId());
        consultaDto.setMedico(new MedicoDto(consulta.getMedico()));
        consultaDto.setPaciente(new PacienteDto(consulta.getPaciente()));
        consultaDto.setRemedios(remediosDto);
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
