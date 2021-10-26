package com.empresa.poc.api.controller.dto;

import com.empresa.poc.api.domain.PlanoDeSaude;

public class PacienteDto {

    private Integer id;
    private String nome;
    private PlanoDeSaude planoDeSaude;

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

    public PlanoDeSaude getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }
}
