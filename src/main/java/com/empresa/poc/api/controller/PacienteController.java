package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.controller.dto.PacienteDto;
import com.empresa.poc.api.domain.Account;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.controller.response.AccountResponse;
import com.empresa.poc.api.domain.Paciente;
import com.empresa.poc.api.service.AccountService;
import com.empresa.poc.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/{accountId}")
    public PacienteDto save(@PathVariable String accountId, @RequestBody PacienteDto dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setPlanoDeSaude(dto.getPlanoDeSaude());

        Account account = accountService.getAccountByAccountId(accountId);
        paciente.setAccount(account);

        Paciente pacienteReturn = pacienteService.save(paciente);
        PacienteDto dtoReturn = new PacienteDto();
        dtoReturn.setId(pacienteReturn.getId());
        dtoReturn.setNome(pacienteReturn.getNome());
        dtoReturn.setPlanoDeSaude(pacienteReturn.getPlanoDeSaude());

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountId(pacienteReturn.getAccount().getAccountId());

        return dtoReturn;
    }

    @GetMapping("/{id}/{accountId}")
    public PacienteDto getOne(@PathVariable Integer id, @PathVariable String accountId) {

        Paciente saved = pacienteService.findByIdAndAccountAccountId(id, accountId);
        PacienteDto dto = new PacienteDto();
        dto.setId(saved.getId());
        dto.setNome(saved.getNome());
        dto.setPlanoDeSaude(saved.getPlanoDeSaude());

        return dto;
    }

    @GetMapping("/{accountId}")
    public List<PacienteDto> todos(@PathVariable String accountId) {

        List<Paciente> pacientes = pacienteService.findByAccountId(accountId);
        List<PacienteDto> pacientesDto = new ArrayList<>();

        for (Paciente paciente : pacientes) {

            PacienteDto pacienteDto = new PacienteDto();
            pacienteDto.setId(paciente.getId());
            pacienteDto.setNome(paciente.getNome());
            pacienteDto.setPlanoDeSaude(paciente.getPlanoDeSaude());

            pacientesDto.add(pacienteDto);

        }

        return pacientesDto;
    }

    @DeleteMapping("/{id}/{accountId}")
    public PacienteDto delete(@PathVariable Integer id, @PathVariable String accountId) {

        if(pacienteService.findById(id).getAccount().equals(accountService.getAccountByAccountId(accountId))) {
            pacienteService.deleteById(id);
        }
        return new PacienteDto();

    }

    @PutMapping("/{id}/{accountId}")
    public PacienteDto alterar(@RequestBody PacienteDto dto, @PathVariable int id, @PathVariable String accountId) {
        Paciente paciente = new Paciente();
        paciente.setId(id);
        paciente.setNome(dto.getNome());
        paciente.setPlanoDeSaude(dto.getPlanoDeSaude());

        Account account = accountService.getAccountByAccountId(accountId);
        paciente.setAccount(account);

        PacienteDto dtoReturn = new PacienteDto();
        if(pacienteService.findById(id).getAccount().equals(account)) {
            Paciente pacienteReturn = pacienteService.save(paciente);
            dtoReturn.setId(pacienteReturn.getId());
            dtoReturn.setNome(pacienteReturn.getNome());
            dtoReturn.setPlanoDeSaude(pacienteReturn.getPlanoDeSaude());
        }
        return dtoReturn;
    }

}