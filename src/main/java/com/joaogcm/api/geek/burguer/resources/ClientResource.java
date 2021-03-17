package com.joaogcm.api.geek.burguer.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaogcm.api.geek.burguer.entities.Client;
import com.joaogcm.api.geek.burguer.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<?> findAllClients() {
		List<Client> clients = clientService.findAllClients();
		return ResponseEntity.ok().body(clients);
	}

	@GetMapping(value = "/{idClient}")
	public ResponseEntity<?> findClientById(@PathVariable Long idClient) {
		Client findClientById = clientService.findClientById(idClient);
		return ResponseEntity.ok().body(findClientById);
	}

	@PostMapping
	public ResponseEntity<?> insertClient(@RequestBody Client client) {
		client = clientService.insertClient(client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idClient}")
				.buildAndExpand(client.getIdClient()).toUri();
		return ResponseEntity.created(uri).body(client);
	}

	@PutMapping(value = "/{idClient}")
	public ResponseEntity<?> updateClientById(@PathVariable Long idClient, @RequestBody Client client) {
		client.setIdClient(idClient);
		clientService.updateClientById(client);
		return ResponseEntity.noContent().build();
	}
}