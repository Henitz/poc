package com.empresa.poc.api.controller;

import com.empresa.poc.api.controller.dto.AccountDto;
import com.empresa.poc.api.controller.request.AccountLoginRequest;
import com.empresa.poc.api.domain.Account;
import com.empresa.poc.api.service.AccountService;
import com.empresa.poc.api.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/accounts")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public AccountDto save(@RequestBody AccountLoginRequest request) {

        Account accountReturn = accountService.save(request);
        AccountDto dtoReturn = new AccountDto();
        dtoReturn.setId(accountReturn.getId());
        dtoReturn.setAccountId(accountReturn.getAccountId());
        dtoReturn.setEmail(accountReturn.getEmail());

        return dtoReturn;
    }
}
