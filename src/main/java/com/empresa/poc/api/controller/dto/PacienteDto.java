package com.empresa.poc.api.controller.dto;

import com.empresa.poc.api.domain.Paciente;

public class PacienteDto {

    private Integer id;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PacienteDto(){ }

    public PacienteDto(Paciente paciente){
        this.id = paciente.getId();
        this.nome = paciente.getNome();
    }

    public PacienteDto(Integer id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
