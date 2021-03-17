package com.joaogcm.api.geek.burguer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.joaogcm.api.geek.burguer.entities.Order;
import com.joaogcm.api.geek.burguer.repositories.OrderRepository;
import com.joaogcm.api.geek.burguer.services.exceptions.DataIntegrityException;
import com.joaogcm.api.geek.burguer.services.exceptions.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAllOrders() {
		List<Order> orders = orderRepository.findAll();
		return orders;
	}

	public Order findOrderById(Long idOrder) {
		Optional<Order> findOrderById = orderRepository.findById(idOrder);
		return findOrderById.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado: ID = " + idOrder));
	}

	public Order insertOrder(Order order) {
		try {
			order.setIdOrder(null);
			return orderRepository.save(order);

		} catch (Exception e) {
			throw new ObjectNotFoundException(e.getMessage());
		}
	}

	public Order updateOrderById(Order order) {
		try {
			findOrderById(order.getIdOrder());
			return orderRepository.save(order);

		} catch (Exception e) {
			throw new ObjectNotFoundException(e.getMessage());
		}
	}

	public void deleteOrderById(Long idOrder) {
		try {
			findOrderById(idOrder);
			orderRepository.deleteById(idOrder);

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover um Pedido que possui Clientes.");
		}
	}
}