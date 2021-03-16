package com.joaogcm.api.geek.burguer.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrder;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date instantOrder;
	
	@ManyToOne
	@JoinColumn(name = "delivery_address_id")
	private Address deliveryAddress;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "orderPayment")
	private Payment paymentOrder;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_order_id")
	private Client clientOrder;
	
	@OneToMany(mappedBy = "idPK.order")
	private Set<OrderItem> itens = new HashSet<OrderItem>();
	
	public Order() {
		
	}
	
	public Order(Long idOrder, Date instantOrder, Address deliveryAddress, Client clientOrder) {
		this.idOrder = idOrder;
		this.instantOrder = instantOrder;
		this.deliveryAddress = deliveryAddress;
		this.clientOrder = clientOrder;
	}
	
	public Long getIdOrder() {
		return idOrder;
	}
	
	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}
	
	public Date getInstantOrder() {
		return instantOrder;
	}
	
	public void setInstantOrder(Date instantOrder) {
		this.instantOrder = instantOrder;
	}
	
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public Payment getPaymentOrder() {
		return paymentOrder;
	}
	
	public void setPaymentOrder(Payment paymentOrder) {
		this.paymentOrder = paymentOrder;
	}
	
	public Client getClientOrder() {
		return clientOrder;
	}
	
	public void setClientOrder(Client clientOrder) {
		this.clientOrder = clientOrder;
	}
	
	public Set<OrderItem> getItens() {
		return itens;
	}
	
	public void setItens(Set<OrderItem> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOrder == null) ? 0 : idOrder.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (idOrder == null) {
			if (other.idOrder != null)
				return false;
		} else if (!idOrder.equals(other.idOrder))
			return false;
		return true;
	}
}