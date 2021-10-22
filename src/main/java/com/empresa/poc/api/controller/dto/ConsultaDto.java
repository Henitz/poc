package com.empresa.poc.api.controller.dto;

import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Paciente;
import com.empresa.poc.api.domain.PlanoDeSaude;


import java.util.Date;

public class ConsultaDto {

    private Integer id;
    private Date data;
    public Medico medico;
    public Paciente paciente;


    public ConsultaDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConsultaDto(Integer id, Date data) {

        this.data = data;
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
