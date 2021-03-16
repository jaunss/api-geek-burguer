package com.joaogcm.api.geek.burguer.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.joaogcm.api.geek.burguer.entities.enums.PaymentStatus;

@Entity
@Table(name = "tb_payment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idPayment;
	private Integer paymentStatus;
	
	@OneToOne
	@JoinColumn(name = "order_payment_id")
	@MapsId
	private Order orderPayment;
	
	public Payment() {
		
	}
	
	public Payment(Long idPayment, PaymentStatus paymentStatus, Order orderPayment) {
		this.idPayment = idPayment;
		this.paymentStatus = paymentStatus.getPaymentStatus();
		this.orderPayment = orderPayment;
	}
	
	public Long getIdPayment() {
		return idPayment;
	}
	
	public void setIdPayment(Long idPayment) {
		this.idPayment = idPayment;
	}
	
	public PaymentStatus getPaymentStatus() {
		return PaymentStatus.status(paymentStatus);
	}
	
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus.getPaymentStatus();
	}
	
	public Order getOrderPayment() {
		return orderPayment;
	}
	
	public void setOrderPayment(Order orderPayment) {
		this.orderPayment = orderPayment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPayment == null) ? 0 : idPayment.hashCode());
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
		Payment other = (Payment) obj;
		if (idPayment == null) {
			if (other.idPayment != null)
				return false;
		} else if (!idPayment.equals(other.idPayment))
			return false;
		return true;
	}
}