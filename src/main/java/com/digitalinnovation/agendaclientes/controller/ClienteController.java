package com.digitalinnovation.agendaclientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinnovation.agendaclientes.model.Cliente;
import com.digitalinnovation.agendaclientes.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService serviceClient;
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente){
		serviceClient.insert(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable String id, @RequestBody Cliente cliente){
		serviceClient.update(id, cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> findAll(){
		return ResponseEntity.ok(serviceClient.findALL());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> finById(@PathVariable String id){
		return ResponseEntity.ok(serviceClient.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		serviceClient.delete(id);
		return ResponseEntity.ok().build();
	}
	

}
