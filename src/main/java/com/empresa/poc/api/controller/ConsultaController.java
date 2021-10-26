package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.ConsultaDto;
import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.controller.dto.PacienteDto;
import com.empresa.poc.api.domain.*;
import com.empresa.poc.api.service.ConsultaService;
import com.empresa.poc.api.service.MedicoService;
import com.empresa.poc.api.service.PacienteService;

import com.empresa.poc.api.service.RemedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/consultas")
@CrossOrigin("*")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;
    @Autowired
    MedicoService medicoService;
    @Autowired
    PacienteService pacienteService;
    @Autowired
    RemedioService remedioService;

    @PostMapping
    public ConsultaDto save(@RequestBody ConsultaDto dto) {
        Consulta consulta = new Consulta();
        //consulta.setId(dto.getId());
        consulta.setData(dto.getData());
        if(!(Objects.isNull(dto.getMedico()) || Objects.isNull(dto.getPaciente()))) {
            Medico medico = new Medico();
            medico.setId(dto.getMedico().getId());
            medico.setNome(dto.getMedico().getNome());
            medico.setEspecialidade(dto.getMedico().getEspecialidade());
            consulta.setMedico(medico);

            Paciente paciente = new Paciente();
            paciente.setId(dto.getPaciente().getId());
            paciente.setNome(dto.getPaciente().getNome());
            paciente.setPlanoDeSaude(dto.getPaciente().getPlanoDeSaude());
            consulta.setPaciente(paciente);
        }
        Consulta consultaReturn = consultaService.save(consulta);
        ConsultaDto dtoReturn = new ConsultaDto();
        dtoReturn.setId(consultaReturn.getId());
        dtoReturn.setData(consultaReturn.getData());

        if(!(Objects.isNull(dto.getMedico()) || Objects.isNull(dto.getPaciente()))) {
            MedicoDto medicoDto = new MedicoDto();
            medicoDto.setId(medicoService.findById(consultaReturn.getMedico().getId()).getId());
            medicoDto.setNome(medicoService.findById(consultaReturn.getMedico().getId()).getNome());
            medicoDto.setEspecialidade(medicoService.findById(consultaReturn.getMedico().getId()).getEspecialidade());
            dtoReturn.setMedico(medicoDto);

            PacienteDto pacienteDto = new PacienteDto();
            pacienteDto.setId(pacienteService.findById(consultaReturn.getPaciente().getId()).getId());
            pacienteDto.setNome(pacienteService.findById(consultaReturn.getPaciente().getId()).getNome());
            pacienteDto.setPlanoDeSaude(pacienteService.findById(consultaReturn.getPaciente().getId()).getPlanoDeSaude());
            dtoReturn.setPaciente(pacienteDto);
        }
        return dtoReturn;
    }

    @GetMapping("/{id}")
    public ConsultaDto one(@PathVariable Integer id) {

        Consulta consultaSaved = consultaService.findById(id);
        ConsultaDto consultaDto = new ConsultaDto();
        consultaDto.setId(consultaSaved.getId());
        consultaDto.setData(consultaSaved.getData());

        Medico medicoSaved = medicoService.findById(id);
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setId(medicoSaved.getId());
        medicoDto.setNome(medicoSaved.getNome());
        medicoDto.setEspecialidade(medicoSaved.getEspecialidade());
        consultaDto.setMedico(medicoDto);

        Paciente pacienteSaved = pacienteService.findById(id);
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setId(pacienteSaved.getId());
        pacienteDto.setNome(pacienteSaved.getNome());
        pacienteDto.setPlanoDeSaude(pacienteSaved.getPlanoDeSaude());
        consultaDto.setPaciente(pacienteDto);

        return consultaDto;
    }
    @GetMapping
    public List<ConsultaDto> todos() {

        List<Consulta> consultas = consultaService.findAll();
        List<ConsultaDto> consultasDto = new ArrayList<>();

        for (Consulta consulta : consultas) {

            ConsultaDto consultaDto = new ConsultaDto();
            consultaDto.setId(consulta.getId());
            consultaDto.setData(consulta.getData());


            consultasDto.add(consultaDto);

        }

        return consultasDto;
    }
}
