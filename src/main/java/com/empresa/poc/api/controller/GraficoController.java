package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.GraficoDto;
import com.empresa.poc.api.repository.ConsultaRepository;
import com.empresa.poc.api.repository.MedicoRepository;
import com.empresa.poc.api.repository.PacienteRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/graficos")
@CrossOrigin("*")
public class GraficoController{

   private final MedicoRepository medicoRepository;
   private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;

    public GraficoController(MedicoRepository medicoRepository,
                             ConsultaRepository consultaRepository,
                             PacienteRepository pacienteRepository
    ) {

        this.medicoRepository = medicoRepository;
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/totais")
    public List<GraficoDto> getTotais(){

        List<GraficoDto> dados = new ArrayList<>();


        GraficoDto consultas = new GraficoDto();
        consultas.setTotal(consultaRepository.total());
        consultas.setCategoria("consultas");

        GraficoDto medicos = new GraficoDto();
        medicos.setTotal(medicoRepository.total());
        medicos.setCategoria("medicos");


        GraficoDto pacientes = new GraficoDto();
        pacientes.setTotal(pacienteRepository.total());
        pacientes.setCategoria("pacientes");

        dados.add(consultas);
        dados.add(medicos);
        dados.add(pacientes);

       return dados;

    }
}

