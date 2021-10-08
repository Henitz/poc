package com.empresa.poc.api.controller.dto;

import com.empresa.poc.api.domain.Consulta;
import com.empresa.poc.api.domain.Remedio;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class ConsultaDto {


    private Integer id;
    private Set<RemedioDto> remedios = new HashSet<>();

    public ConsultaDto(){


    }

    public ConsultaDto(Consulta consulta){

        this.id = consulta.getId();

        Set<RemedioDto> remediosDto = new HashSet<>();

        for(Remedio r : consulta.getRemedios()){
            RemedioDto rDto = new RemedioDto();
            rDto.setId(r.getId());
            rDto.setNome(r.getNome());
            remediosDto.add(rDto);
        }

        this.setRemedios(remediosDto);

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<RemedioDto> getRemedios() {
        return remedios;
    }

    public void setRemedios(Set<RemedioDto> remedios) {
        this.remedios = remedios;
    }
}
