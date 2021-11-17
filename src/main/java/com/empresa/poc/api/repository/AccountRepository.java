package com.empresa.poc.api.repository;

import com.empresa.poc.api.domain.Account;
import com.empresa.poc.api.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountId(String accountId);
    Account findByEmail(String email);
}
