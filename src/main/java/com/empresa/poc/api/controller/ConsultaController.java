package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.ConsultaDto;
import com.empresa.poc.api.controller.dto.RemedioDto;
import com.empresa.poc.api.domain.Consulta;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Paciente;
import com.empresa.poc.api.domain.Remedio;
import com.empresa.poc.api.service.ConsultaService;
import com.empresa.poc.api.service.MedicoService;
import com.empresa.poc.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;
    @Autowired
    MedicoService medicoService;
    @Autowired
    PacienteService pacienteService;


    @PostMapping("/consultas")
    public ConsultaDto save(@RequestBody ConsultaDto dto) {
        Consulta consulta = new Consulta();
        consulta.setId(dto.getId());
        consulta.setData(dto.getData());
        consulta.setMedico(dto.getMedico());
        consulta.setPaciente(dto.getPaciente());


        Consulta consultaReturn = consultaService.save(consulta);
        ConsultaDto dtoReturn = new ConsultaDto();
        dtoReturn.setId(consultaReturn.getId());
        dtoReturn.setData(consultaReturn.getData());

        Medico medico = new Medico();
        medico.setId(medicoService.findById(consultaReturn.getMedico().getId()).getId());
        medico.setNome(medicoService.findById(consultaReturn.getMedico().getId()).getNome());
        dtoReturn.setMedico(medico);

        Paciente paciente = new Paciente();
        paciente.setId(pacienteService.findById(consultaReturn.getPaciente().getId()).getId());
        paciente.setNome(pacienteService.findById(consultaReturn.getPaciente().getId()).getNome());
        dtoReturn.setPaciente(paciente);

//        dtoReturn.setPaciente(dto.getPaciente());
        medicoService.findById(dto.medico.getId());

        return dtoReturn;
    }

}
