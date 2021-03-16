package com.joaogcm.api.geek.burguer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaogcm.api.geek.burguer.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
}