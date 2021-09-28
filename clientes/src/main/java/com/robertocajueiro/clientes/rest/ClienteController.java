package com.robertocajueiro.clientes.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import com.robertocajueiro.clientes.model.entity.Cliente;
import com.robertocajueiro.clientes.model.repository.ClientesRepository;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	private final ClientesRepository repository;
	
	@Autowired
	public ClienteController(ClientesRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Cliente> obterTodos(){
		return repository.findAll();
	}
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar( @RequestBody @Validated Cliente cliente ){
        return repository.save(cliente);
    }

}
