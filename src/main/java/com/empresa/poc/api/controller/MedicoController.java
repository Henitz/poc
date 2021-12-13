package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.controller.response.AccountResponse;
import com.empresa.poc.api.domain.Account;
import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.service.AccountService;
import com.empresa.poc.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicos")
@CrossOrigin("*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/{accountId}")
    public MedicoDto save(@PathVariable String accountId, @RequestBody MedicoDto dto){
        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());

        Account account = accountService.getAccountByAccountId(accountId);
        medico.setAccount(account);

        Medico medicoReturn = medicoService.save(medico);
        MedicoDto dtoReturn = new MedicoDto();
        dtoReturn.setId(medicoReturn.getId());
        dtoReturn.setNome(medicoReturn.getNome());
        dtoReturn.setEspecialidade(medicoReturn.getEspecialidade());

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountId(medicoReturn.getAccount().getAccountId());

        return dtoReturn;
    }

    @GetMapping("/{id}/{accountId}")
    public MedicoDto um(@PathVariable Integer id, @PathVariable String accountId) {

        Medico medicoReturn = medicoService.findByIdAndAccountAccountId(id, accountId);
        MedicoDto dtoReturn = new MedicoDto();
        dtoReturn.setId(medicoReturn.getId());
        dtoReturn.setNome(medicoReturn.getNome());
        dtoReturn.setEspecialidade(medicoReturn.getEspecialidade());

        return dtoReturn;
    }

    @GetMapping("/{accountId}")
    public List<MedicoDto> todos(@PathVariable String accountId) {

        List<Medico> medicos = medicoService.findByAccountId(accountId);
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

    @DeleteMapping("/{id}/{accountId}")
    public MedicoDto delete(@PathVariable Integer id, @PathVariable String accountId) {

        if(medicoService.findById(id).getAccount().equals(accountService.getAccountByAccountId(accountId))) {
            medicoService.deleteById(id);
        }

        return new MedicoDto();

    }

    @PutMapping("/{id}/{accountId}")
    public MedicoDto alterar(@RequestBody MedicoDto dto, @PathVariable int id, @PathVariable String accountId) {

        Medico medico = new Medico();
        medico.setId(id);
        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());

        Account account = accountService.getAccountByAccountId(accountId);
        medico.setAccount(account);

        MedicoDto dtoReturn = new MedicoDto();
        if(medicoService.findById(id).getAccount().equals(account)){
            Medico medicoReturn = medicoService.save(medico);
            dtoReturn.setId(medicoReturn.getId());
            dtoReturn.setNome(medicoReturn.getNome());
            dtoReturn.setEspecialidade(medicoReturn.getEspecialidade());
        }

        return dtoReturn;
    }
}
