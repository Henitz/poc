package com.empresa.poc.api.controller.dto;

import com.empresa.poc.api.domain.Especialidade;

public class MedicoDto {

    private String nome;
    private Especialidade especialidade;

    public MedicoDto(){

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
}
