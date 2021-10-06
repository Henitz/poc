package com.empresa.poc.api.controller.dto;

public class MedicoDto {

    private String nome;

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
}
