package com.empresa.poc.api.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "medico")
    private Set<Consulta> consultas;

    public Medico(){
    }

    public Medico(String nome){
        this.nome = nome;
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

    public Set<Consulta> getConsulta() {
        return consultas;
    }

    public void setConsulta(Set<Consulta> consultas) {
        this.consultas = consultas;
    }
}
