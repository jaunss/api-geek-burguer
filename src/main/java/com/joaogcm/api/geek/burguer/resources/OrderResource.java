package com.joaogcm.api.geek.burguer.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joaogcm.api.geek.burguer.entities.Order;
import com.joaogcm.api.geek.burguer.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<?> findAllOrders() {
		List<Order> orders = orderService.findAllOrders();
		return ResponseEntity.ok().body(orders);
	}

	@GetMapping(value = "/{idOrder}")
	public ResponseEntity<?> findOrderById(@PathVariable Long idOrder) {
		Order findOrderById = orderService.findOrderById(idOrder);
		return ResponseEntity.ok().body(findOrderById);
	}

	@PostMapping
	public ResponseEntity<?> insertOrder(@RequestBody Order order) {
		order = orderService.insertOrder(order);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idOrder}").buildAndExpand(order.getIdOrder())
				.toUri();
		return ResponseEntity.created(uri).body(order);
	}

	@PutMapping(value = "/{idOrder}")
	public ResponseEntity<?> updateOrderById(@PathVariable Long idOrder, @RequestBody Order order) {
		order.setIdOrder(idOrder);
		order = orderService.updateOrderById(order);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{idOrder}")
	public ResponseEntity<?> deleteOrderById(@PathVariable Long idOrder) {
		orderService.deleteOrderById(idOrder);
		return ResponseEntity.noContent().build();
	}
}