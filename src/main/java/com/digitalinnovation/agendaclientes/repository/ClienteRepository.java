package com.digitalinnovation.agendaclientes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitalinnovation.agendaclientes.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{

}
