package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.*;
import com.empresa.poc.api.controller.response.AccountResponse;
import com.empresa.poc.api.domain.*;
import com.empresa.poc.api.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private AccountService accountService;


    @PostMapping("/{accountId}")
    public ConsultaDto save(@PathVariable String accountId, @RequestBody ConsultaDto dto) throws ParseException {
        Consulta consulta = new Consulta();
        consulta.setData(formataDataIda(dto.getData()));

        Account account = accountService.getAccountByAccountId(accountId);
        consulta.setAccount(account);

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
        dtoReturn.setData(formataDataVolta(consultaReturn.getData()));

        AccountDto accountDto = new AccountDto();
        accountDto.setId(consultaReturn.getAccount().getId());

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

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountId(consulta.getAccount().getAccountId());

        return dtoReturn;
    }

    @GetMapping("/{id}/{accountId}")
    public ConsultaDto one(@PathVariable Integer id, @PathVariable String accountId) {

        Consulta consultaSaved = consultaService.findByIdAndAccountAccountId(id, accountId);
        ConsultaDto consultaDto = new ConsultaDto();
        consultaDto.setId(consultaSaved.getId());
        consultaDto.setData(formataDataVolta(consultaSaved.getData()));

        Medico medicoSaved = medicoService.findById(consultaSaved.getMedico().getId());
        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setId(medicoSaved.getId());
        medicoDto.setNome(medicoSaved.getNome());
        medicoDto.setEspecialidade(medicoSaved.getEspecialidade());
        consultaDto.setMedico(medicoDto);

        Paciente pacienteSaved = pacienteService.findById(consultaSaved.getPaciente().getId());
        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setId(pacienteSaved.getId());
        pacienteDto.setNome(pacienteSaved.getNome());
        pacienteDto.setPlanoDeSaude(pacienteSaved.getPlanoDeSaude());
        consultaDto.setPaciente(pacienteDto);


        Set<RemedioDto> remediosDto = new HashSet<>();


        for (Remedio  r : consultaSaved.getRemedios()) {
            RemedioDto remedioDto = new RemedioDto();
            remedioDto.setId(r.getId());
            remedioDto.setNome(remedioService.findById(r.getId()).getNome());
            remediosDto.add(remedioDto);
        }
        consultaDto.setRemedios(remediosDto);


        return consultaDto;
    }

    private String formataDataVolta(Date date){
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        return formatador.format(date);
    }

    private Date formataDataIda(String date) throws ParseException {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        return formatador.parse(date);
    }

    @GetMapping("/{accountId}")
    public List<ConsultaDto> todos(@PathVariable String accountId) {

        List<Consulta> consultas = consultaService.findByAccountId(accountId);
        List<ConsultaDto> consultasDto = new ArrayList<>();

        for (Consulta consulta : consultas) {

            ConsultaDto consultaDto = new ConsultaDto();
            consultaDto.setId(consulta.getId());

            consultaDto.setData(formataDataVolta(consulta.getData()));

            MedicoDto medicoDto = new MedicoDto();
            medicoDto.setId(consulta.getMedico().getId());
            medicoDto.setNome(consulta.getMedico().getNome());
            medicoDto.setEspecialidade(consulta.getMedico().getEspecialidade());
            consultaDto.setMedico(medicoDto);

            PacienteDto pacienteDto = new PacienteDto();
            pacienteDto.setId(consulta.getPaciente().getId());
            pacienteDto.setNome(consulta.getPaciente().getNome());
            pacienteDto.setPlanoDeSaude(consulta.getPaciente().getPlanoDeSaude());
            consultaDto.setPaciente(pacienteDto);


            Set<RemedioDto> remediosDto = new HashSet<>();

            if(consulta.getRemedios().size()!=0) {
                for (Remedio r : consulta.getRemedios()) {
                    RemedioDto remedioDto = new RemedioDto();
                    remedioDto.setId(r.getId());
                    remedioDto.setNome(remedioService.findById(r.getId()).getNome());
                    remediosDto.add(remedioDto);
                }
                consultaDto.setRemedios(remediosDto);
            }

            consultasDto.add(consultaDto);


        }

        return consultasDto;
    }

    @DeleteMapping("/{id}")
    public ConsultaDto delete(@PathVariable Integer id) {

        consultaService.deleteById(id);

        return new ConsultaDto();

    }

    @PutMapping("/{id}")
    public ConsultaDto alterar(@RequestBody ConsultaDto dto, @PathVariable int id) throws ParseException {
        Consulta consulta = new Consulta();
        consulta.setId(id);
        consulta.setData(formataDataIda(dto.getData()));

        Medico medico = new Medico();
        medico.setId(dto.getMedico().getId());

        Paciente paciente = new Paciente();
        paciente.setId(dto.getPaciente().getId());

        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        Set<Remedio> remedios = new HashSet<>();

        for(RemedioDto r : dto.getRemedios()) {
            Remedio remedio = new Remedio();
            remedio.setId(r.getId());
            remedios.add(remedio);
        }

        consulta.setRemedios(remedios);

        Consulta consultaReturn = consultaService.save(consulta);

        ConsultaDto dtoReturn = new ConsultaDto();

        dtoReturn.setId(consultaReturn.getId());
        dtoReturn.setData(formataDataVolta(consultaReturn.getData()));

        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setId(consultaReturn.getMedico().getId());
        medicoDto.setNome(consultaReturn.getMedico().getNome());
        medicoDto.setEspecialidade(consultaReturn.getMedico().getEspecialidade());

        dtoReturn.setMedico(medicoDto);

        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setId(consultaReturn.getPaciente().getId());
        pacienteDto.setNome(consultaReturn.getPaciente().getNome());
        pacienteDto.setPlanoDeSaude(consultaReturn.getPaciente().getPlanoDeSaude());

        dtoReturn.setPaciente(pacienteDto);

        Set<RemedioDto> remediosDto = new HashSet<>();

        for (Remedio r : consultaReturn.getRemedios()) {
            RemedioDto remedioDto = new RemedioDto();
            remedioDto.setId(r.getId());
            remedioDto.setNome(remedioService.findById(r.getId()).getNome());
            remediosDto.add(remedioDto);
        }
        dtoReturn.setRemedios(remediosDto);





        return dtoReturn;
    }

}
