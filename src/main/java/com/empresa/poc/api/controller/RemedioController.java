package com.empresa.poc.api.controller;


import com.empresa.poc.api.controller.dto.RemedioDto;
import com.empresa.poc.api.domain.Remedio;
import com.empresa.poc.api.service.RemedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RemedioController {

    @Autowired
    RemedioService remedioService;

    @PostMapping("/remedios")
    public RemedioDto save(@RequestBody RemedioDto dto) {
        Remedio remedio = new Remedio();
        remedio.setNome(dto.getNome());

        Remedio remedioReturn = remedioService.save(remedio);
        RemedioDto dtoReturn = new RemedioDto();
        dtoReturn.setId(remedioReturn.getId());
        dtoReturn.setNome(remedioReturn.getNome());

        return dtoReturn;
    }
}
