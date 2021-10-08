package com.empresa.poc.api.controller.dto;

import com.empresa.poc.api.domain.Medico;

public class MedicoDto {

    private Integer id;
    private String nome;

    public MedicoDto(){ }

    public MedicoDto(Medico medico){
        this.id = medico.getId();
        this.nome = medico.getNome();
    }

    public MedicoDto(Integer id, String nome){
        this.nome = nome;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
