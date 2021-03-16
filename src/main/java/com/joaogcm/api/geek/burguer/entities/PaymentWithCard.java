package com.joaogcm.api.geek.burguer.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.joaogcm.api.geek.burguer.entities.enums.PaymentStatus;

@Entity
@Table(name = "tb_payment_with_card")
public class PaymentWithCard extends Payment {

	private static final long serialVersionUID = 1L;
	
	private Integer numberInstallments;
	
	public PaymentWithCard() {
		
	}
	
	public PaymentWithCard(Long idPayment,PaymentStatus paymentStatus, Order orderPayment, Integer numberInstallments) {
		super(idPayment, paymentStatus, orderPayment);
		this.numberInstallments = numberInstallments;
	}
	
	public Integer getNumberInstallments() {
		return numberInstallments;
	}
	
	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}
}