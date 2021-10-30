package com.empresa.poc.api.domain;

import javax.persistence.*;

@Entity
public class Paciente {

    public Paciente(){ }

    public Paciente(String nome, PlanoDeSaude planoDeSaude){
        this.nome = nome;
        this.planoDeSaude = planoDeSaude;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @Enumerated(EnumType.ORDINAL)
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
