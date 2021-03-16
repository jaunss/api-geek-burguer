package com.joaogcm.api.geek.burguer.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaogcm.api.geek.burguer.entities.Order;
import com.joaogcm.api.geek.burguer.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Order> orders = orderService.findAll();
		return ResponseEntity.ok().body(orders);
	}

	@GetMapping(value = "/{idOrder}")
	public ResponseEntity<?> findById(@PathVariable Long idOrder) {
		Order findOrderById = orderService.findById(idOrder);
		return ResponseEntity.ok().body(findOrderById);
	}
}