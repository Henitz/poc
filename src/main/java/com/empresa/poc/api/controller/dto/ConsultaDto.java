package com.empresa.poc.api.controller.dto;

import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.domain.Paciente;
import com.empresa.poc.api.domain.PlanoDeSaude;


import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Set;

public class ConsultaDto {

    private Integer id;
    private String data;
    public MedicoDto medico;
    public PacienteDto paciente;

    public Set<RemedioDto> remedios;

    public Set<RemedioDto> getRemedios() {
        return remedios;
    }

    public void setRemedios(Set<RemedioDto> remedios) {
        this.remedios = remedios;
    }

    public ConsultaDto() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConsultaDto(Integer id, String data) {

        this.data = data;
        this.id = id;
    }



    public MedicoDto getMedico() {
        return medico;
    }

    public void setMedico(MedicoDto medico) {
        this.medico = medico;
    }


    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }


}
