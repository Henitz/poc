package com.empresa.poc.api.controller.dto;

import com.empresa.poc.api.domain.PlanoDeSaude;

public class PacienteDto {
    private String nome;
    private PlanoDeSaude planodesaude;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PlanoDeSaude getPlanodesaude() {
        return planodesaude;
    }

    public void setPlanodesaude(PlanoDeSaude planodesaude) {
        this.planodesaude = planodesaude;
    }
}
