package com.digitalinnovation.agendaclientes.service;

import com.digitalinnovation.agendaclientes.model.Cliente;

public interface ClienteService {
	
	void insert(Cliente cliente);
	
	void update(String id, Cliente cliente);
	
	void delete(String id);
	
	Cliente findById(String id);
	
	Iterable<Cliente> findALL();

}
