package com.joaogcm.api.geek.burguer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaogcm.api.geek.burguer.entities.Order;
import com.joaogcm.api.geek.burguer.repositories.OrderRepository;
import com.joaogcm.api.geek.burguer.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll() {
		List<Order> orders = orderRepository.findAll();
		return orders;
	}

	public Order findById(Long idOrder) {
		Optional<Order> findOrderById = orderRepository.findById(idOrder);
		return findOrderById.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado: ID = " + idOrder));
	}
}