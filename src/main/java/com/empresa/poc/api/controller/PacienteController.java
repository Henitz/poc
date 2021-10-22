package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.controller.dto.PacienteDto;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Paciente;
import com.empresa.poc.api.service.MedicoService;
import com.empresa.poc.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/pacientes")
    public PacienteDto save(@RequestBody PacienteDto dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setPlanodesaude(dto.getPlanodesaude());


        Paciente pacienteReturn = pacienteService.save(paciente);
        PacienteDto dtoReturn = new PacienteDto();
        dtoReturn.setNome(pacienteReturn.getNome());
        dtoReturn.setPlanodesaude(pacienteReturn.getPlanodesaude());

        return dtoReturn;
    }
}