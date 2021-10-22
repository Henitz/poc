package com.empresa.poc.api.domain;

import javax.persistence.*;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @Enumerated(EnumType.ORDINAL)
    private PlanoDeSaude planodesaude;

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

    public PlanoDeSaude getPlanodesaude() {
        return planodesaude;
    }

    public void setPlanodesaude(PlanoDeSaude planodesaude) {
        this.planodesaude = planodesaude;
    }
}
