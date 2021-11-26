package com.empresa.poc.api.controller;


import com.empresa.poc.api.controller.dto.MedicoDto;
import com.empresa.poc.api.controller.dto.RemedioDto;
import com.empresa.poc.api.controller.response.AccountResponse;
import com.empresa.poc.api.domain.Account;
import com.empresa.poc.api.domain.Remedio;
import com.empresa.poc.api.service.AccountService;
import com.empresa.poc.api.service.RemedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/remedios")
@CrossOrigin("*")
public class RemedioController {

    @Autowired
    RemedioService remedioService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/{accountId}")
    public RemedioDto save(@PathVariable String accountId, @RequestBody MedicoDto dto) {
        Remedio remedio = new Remedio();
        remedio.setNome(dto.getNome());

        Account account = accountService.getAccountByAccountId(accountId);
        remedio.setAccount(account);

        Remedio remedioReturn = remedioService.save(remedio);
        RemedioDto dtoReturn = new RemedioDto();
        dtoReturn.setId(remedioReturn.getId());
        dtoReturn.setNome(remedioReturn.getNome());

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountId(remedioReturn.getAccount().getAccountId());

        return dtoReturn;
    }

    @GetMapping("/{id}/{accountId}")
    public RemedioDto one(@PathVariable Integer id, @PathVariable String accountId) {

        Remedio saved = remedioService.findByIdAndAccountAccountId(id, accountId);

        RemedioDto dto = new RemedioDto();
        dto.setId(saved.getId());
        dto.setNome(saved.getNome());

        return dto;
    }

    @GetMapping("/{accountId}")
    public List<RemedioDto> todos(@PathVariable String accountId) {

        List<Remedio> remedios = remedioService.findByAccountId(accountId);
        List<RemedioDto> remediosDto = new ArrayList<>();

        for (Remedio remedio : remedios) {

            RemedioDto remedioDto = new RemedioDto();
            remedioDto.setId(remedio.getId());
            remedioDto.setNome(remedio.getNome());


            remediosDto.add(remedioDto);

        }

        return remediosDto;
    }

    @DeleteMapping("/{id}/{accountId}")
    public RemedioDto delete(@PathVariable Integer id, @PathVariable String accountId) {

        if (remedioService.findById(id).getAccount().equals(accountService.getAccountByAccountId(accountId))) {
            remedioService.deleteById(id);
        }
        return new RemedioDto();
    }

    @PutMapping("/{id}/{accountId}")
    public RemedioDto alterar(@RequestBody RemedioDto dto, @PathVariable int id, @PathVariable String accountId) {
        Remedio remedio = new Remedio();
        remedio.setId(id);
        remedio.setNome(dto.getNome());

        Account account = accountService.getAccountByAccountId(accountId);
        remedio.setAccount(account);

        RemedioDto dtoReturn = new RemedioDto();
        if (remedioService.findById(id).getAccount().equals(account)) {
            Remedio remedioReturn = remedioService.save(remedio);
            dtoReturn.setId(remedioReturn.getId());
            dtoReturn.setNome(remedioReturn.getNome());
        }

        return dtoReturn;
    }
}
