package com.empresa.poc.api.controller.dto;

import com.empresa.poc.api.controller.response.AccountResponse;
import com.empresa.poc.api.domain.Especialidade;

public class MedicoDto {
    private Integer id;
    private String nome;
    private Especialidade especialidade;
    private AccountResponse account;


    public MedicoDto(){

    }

    public AccountResponse getAccount() {
        return account;
    }

    public void setAccount(AccountResponse account) {
        this.account = account;
    }

    public MedicoDto(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

