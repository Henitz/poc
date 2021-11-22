package com.empresa.poc.api.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date data;

    @ManyToMany
    @JoinTable(
            name = "remedios_consultas",
            joinColumns = @JoinColumn(name = "consulta_id"),
            inverseJoinColumns = @JoinColumn(name = "remedio_id"))
    private Set<Remedio> remedios = new HashSet<>();

    public Set<Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(Set<Remedio> remedios) {
        this.remedios = remedios;
    }

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;




    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;



    public Consulta(){

    }

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
