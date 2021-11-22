package com.empresa.poc.api.domain;

import javax.persistence.*;

@Entity
public class Paciente {

    public Paciente(){ }

    public Paciente(String nome, PlanoDeSaude planoDeSaude, Account account){
        this.nome = nome;
        this.planoDeSaude = planoDeSaude;
        this.account = account;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @Enumerated(EnumType.ORDINAL)
    private PlanoDeSaude planoDeSaude;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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

    public PlanoDeSaude getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }
}
