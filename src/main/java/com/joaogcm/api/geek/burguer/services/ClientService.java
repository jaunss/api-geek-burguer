package com.joaogcm.api.geek.burguer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaogcm.api.geek.burguer.entities.Client;
import com.joaogcm.api.geek.burguer.repositories.ClientRepository;
import com.joaogcm.api.geek.burguer.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> findAll() {
		List<Client> clients = clientRepository.findAll();
		return clients;
	}
	
	public Client findById(Long idClient) {
		Optional<Client> findClientById = clientRepository.findById(idClient);
		return findClientById.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado: ID = " + idClient));
	}
}