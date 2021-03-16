package com.joaogcm.api.geek.burguer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaogcm.api.geek.burguer.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
}