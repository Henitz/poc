package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.repository.MedicoRepository;
import com.empresa.poc.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@CrossOrigin("*")
public class MedicoController {

    private MedicoRepository medicoRepository;

    @Autowired
    MedicoService medicoService;

    @PostMapping
    public MedicoDto save(@RequestBody MedicoDto dto){

        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());

        Medico medicoReturn = medicoService.save(medico);
        MedicoDto dtoReturn = new MedicoDto();
        dtoReturn.setId(medicoReturn.getId());
        dtoReturn.setNome(medicoReturn.getNome());
        dtoReturn.setEspecialidade(medicoReturn.getEspecialidade());

        return dtoReturn;
    }

    @GetMapping("/{id}")
    public MedicoDto um(@PathVariable Integer id) {

        Medico medicoReturn = medicoService.findById(id);
        MedicoDto dtoReturn = new MedicoDto();
        dtoReturn.setId(medicoReturn.getId());
        dtoReturn.setNome(medicoReturn.getNome());
        dtoReturn.setEspecialidade(medicoReturn.getEspecialidade());

        return dtoReturn;
    }

//    @GetMapping
//    public List<MedicoDto> todos() {
//
//        Medico medicoReturn = medicoService.findById(id);
//        MedicoDto dtoReturn = new MedicoDto();
//        dtoReturn.setId(medicoReturn.getId());
//        dtoReturn.setNome(medicoReturn.getNome());
//        dtoReturn.setEspecialidade(medicoReturn.getEspecialidade());
//
//
//
//
//        return (List<dtoReturn>) MedicoRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
//    }
}
