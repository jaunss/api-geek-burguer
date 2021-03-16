package com.joaogcm.api.geek.burguer.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.joaogcm.api.geek.burguer.entities.enums.PaymentStatus;

@Entity
@Table(name = "tb_payment_with_boleto")
public class PaymentWithBoleto extends Payment {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dueDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date payday;
	
	public PaymentWithBoleto() {
		
	}
	
	public PaymentWithBoleto(Long idPayment, PaymentStatus paymentStatus, Order orderPayment, Date dueDate, Date payday) {
		super(idPayment, paymentStatus, orderPayment);
		this.dueDate = dueDate;
		this.payday = payday;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public Date getPayday() {
		return payday;
	}
	
	public void setPayday(Date payday) {
		this.payday = payday;
	}
}