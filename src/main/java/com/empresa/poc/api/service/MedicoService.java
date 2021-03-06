package com.empresa.poc.api.service;

import com.empresa.poc.api.domain.Medico;
import com.empresa.poc.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public Medico findById(Integer id) {
        return medicoRepository.findById(id).get();
    }

    public Medico save(Medico medico) {

        switch (medico.getEspecialidade().name()) {
            case "ORTOPEDISTA":
                medico.setSalario(20000.0);

            case "CLINICO_GERAL":
                medico.setSalario(30000.0);

            case "NEUROLOGISTA":
                medico.setSalario(35000.0);
        }

        return medicoRepository.save(medico);
    }

    public List<Medico> findAll() {

        return (List<Medico>) medicoRepository.findAll();
    }

    public List<Medico> findByAccountId(String accountId) {

        return  medicoRepository.findByAccountAccountId(accountId);
    }

    public Medico deleteById(Integer id) {

        medicoRepository.deleteById(id);
        return new Medico();
    }

    public Medico findByIdAndAccountAccountId(Integer id, String accountId) {
        return  medicoRepository.findByIdAndAccountAccountId(id, accountId);
    }
}
