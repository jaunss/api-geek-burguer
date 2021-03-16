package com.joaogcm.api.geek.burguer.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogcm.api.geek.burguer.entities.Client;
import com.joaogcm.api.geek.burguer.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Client> clients = clientService.findAll();
		return ResponseEntity.ok().body(clients);
	}
	
	@GetMapping(value = "/{idClient}")
	public ResponseEntity<?> findById(@PathVariable Long idClient) {
		Client findClientById = clientService.findById(idClient);
		return ResponseEntity.ok().body(findClientById);
	}
}