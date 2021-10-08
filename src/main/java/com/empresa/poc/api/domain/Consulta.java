package com.empresa.poc.api.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Paciente paciente;

    @ManyToMany
    @JoinTable(
            name = "remedio_consulta",
            joinColumns = @JoinColumn(name = "consulta_id"),
            inverseJoinColumns = @JoinColumn(name = "remedio_id"))
    private Set<Remedio> remedios = new HashSet<>();

    public Consulta(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(Set<Remedio> remedios) {
        this.remedios = remedios;
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
