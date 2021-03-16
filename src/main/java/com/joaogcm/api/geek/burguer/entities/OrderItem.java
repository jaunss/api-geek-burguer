package com.joaogcm.api.geek.burguer.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joaogcm.api.geek.burguer.entities.pk.OrderItemPK;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private OrderItemPK idPK = new OrderItemPK();

	private Double discountItem;
	private Integer amountItem;
	private Double priceItem;

	public OrderItem() {

	}

	public OrderItem(Product product, Order order, Double discountItem, Integer amountItem, Double priceItem) {
		idPK.setProduct(product);
		idPK.setOrder(order);
		this.discountItem = discountItem;
		this.amountItem = amountItem;
		this.priceItem = priceItem;
	}

	public OrderItemPK getIdPK() {
		return idPK;
	}

	public void setIdPK(OrderItemPK idPK) {
		this.idPK = idPK;
	}

	public Product getProduct() {
		return idPK.getProduct();
	}

	@JsonIgnore
	public Order getOrder() {
		return idPK.getOrder();
	}

	public Double getDiscountItem() {
		return discountItem;
	}

	public void setDiscountItem(Double discountItem) {
		this.discountItem = discountItem;
	}

	public Integer getAmountItem() {
		return amountItem;
	}

	public void setAmountItem(Integer amountItem) {
		this.amountItem = amountItem;
	}

	public Double getPriceItem() {
		return priceItem;
	}

	public void setPriceItem(Double priceItem) {
		this.priceItem = priceItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPK == null) ? 0 : idPK.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (idPK == null) {
			if (other.idPK != null)
				return false;
		} else if (!idPK.equals(other.idPK))
			return false;
		return true;
	}
}