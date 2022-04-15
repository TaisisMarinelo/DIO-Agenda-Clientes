package com.digitalinnovation.agendaclientes.service.Implemente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinnovation.agendaclientes.model.Cliente;
import com.digitalinnovation.agendaclientes.model.Endereco;
import com.digitalinnovation.agendaclientes.repository.ClienteRepository;
import com.digitalinnovation.agendaclientes.repository.EnderecoRepository;
import com.digitalinnovation.agendaclientes.service.ClienteService;
import com.digitalinnovation.agendaclientes.service.ViaCepService;

@Service
public class ClienteServiceImplemente implements ClienteService{
	
	@Autowired
	private ClienteRepository repositoryClient;
	
	@Autowired
	private EnderecoRepository repositoryEndereco;
	
	@Autowired
	private ViaCepService serviceCep;

	
	@Override
	public void insert(Cliente cliente) {
		insertClientEndereco(cliente);
		
	}

	@Override
	public void update(String id, Cliente cliente) {
		Optional<Cliente> atualizaCliente = repositoryClient.findById(id);
		if(atualizaCliente.isPresent()) {
			insertClientEndereco(cliente);
		}
		
	}

	@Override
	public void delete(String id) {
		repositoryClient.deleteById(id);
		
	}

	@Override
	public Cliente findById(String id) {
		Optional<Cliente> cliente = repositoryClient.findById(id);
		return cliente.get();
	}

	@Override
	public Iterable<Cliente> findALL() {
		return repositoryClient.findAll();
	}
	
	private void insertClientEndereco(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = repositoryEndereco.findById(cep).orElseGet(() -> {
			Endereco buscaEndereco = serviceCep.consutaCep(cep);
			repositoryEndereco.save(buscaEndereco);
			return buscaEndereco;
		});
		
		cliente.setEndereco(endereco);
		repositoryClient.save(cliente);
	}

}
