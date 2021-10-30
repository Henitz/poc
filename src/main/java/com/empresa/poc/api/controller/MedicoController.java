package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.repository.MedicoRepository;
import com.empresa.poc.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicos")
@CrossOrigin("*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

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

    @GetMapping
    public List<MedicoDto> todos() {

        List<Medico> medicos = medicoService.findAll();
        List<MedicoDto> medicosDto = new ArrayList<>();

        for (Medico medico : medicos) {

            MedicoDto medicoDto = new MedicoDto();
            medicoDto.setId(medico.getId());
            medicoDto.setNome(medico.getNome());
            medicoDto.setEspecialidade(medico.getEspecialidade());

            medicosDto.add(medicoDto);

        }

        return medicosDto;
    }

    @DeleteMapping("/{id}")
    public MedicoDto delete(@PathVariable Integer id) {

        medicoService.deleteById(id);

        return new MedicoDto();

    }

    @PutMapping("/{id}")
    public MedicoDto alterar(@RequestBody MedicoDto dto, @PathVariable int id) {
        Medico medico = new Medico();
        medico.setId(id); //para alterar passo o id
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());

        Medico medicoReturn = medicoService.save(medico);
        MedicoDto dtoReturn = new MedicoDto();
        dtoReturn.setId(medicoReturn.getId());
        dtoReturn.setNome(medicoReturn.getNome());
        dtoReturn.setEspecialidade(medicoReturn.getEspecialidade());

        return dtoReturn;
    }
}
