package com.empresa.poc.api.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date data;


    // Relacionamento vai aqui
    // Medico
    //Paciente
    //GetandSetter

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;


    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;


//    @ManyToOne
//    @JoinColumn(name = "plano_de_saude_id")
//    private PlanoDeSaude planodesaude;

    public Consulta(){

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

//    public PlanoDeSaude getPlanodesaude() {
//        return planodesaude;
//    }
//
//    public void setPlanodesaude(PlanoDeSaude planodesaude) {
//        this.planodesaude = planodesaude;
//    }
}
