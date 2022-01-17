package com.empresa.poc.api.repository;

import com.empresa.poc.api.domain.Medico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Integer> {

    @Query("select count(c) from Medico c")
    public int total();

    List<Medico> findByAccountAccountId(String accountId);

    Medico findByIdAndAccountAccountId(Integer id, String accountId);
}
