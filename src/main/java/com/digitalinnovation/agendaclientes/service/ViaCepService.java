package com.digitalinnovation.agendaclientes.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.digitalinnovation.agendaclientes.model.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
	
	@GetMapping("/{cep}/json/")
	Endereco consutaCep(@PathVariable("cep")String cep);

}
