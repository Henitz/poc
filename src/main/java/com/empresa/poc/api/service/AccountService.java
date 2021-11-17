package com.empresa.poc.api.service;

import com.empresa.poc.api.controller.request.AccountLoginRequest;
import com.empresa.poc.api.domain.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    Account save(AccountLoginRequest accountLoginRequest);
    Account getAccountByAccountId(String id);
    String getAccountByEmail(String email);
}
