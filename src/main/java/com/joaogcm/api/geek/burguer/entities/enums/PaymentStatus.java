package com.joaogcm.api.geek.burguer.entities.enums;

public enum PaymentStatus {

	AwaitingPayment(1, "Awaiting Payment"), Pending(2, "Pending"), Settled(3, "Settled"), Canceled(4, "Canceled");

	private Integer paymentStatus;
	private String descriptionPayment;

	private PaymentStatus() {

	}

	private PaymentStatus(Integer paymentStatus, String descriptionPayment) {
		this.paymentStatus = paymentStatus;
		this.descriptionPayment = descriptionPayment;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getDescriptionPayment() {
		return descriptionPayment;
	}

	public void setDescriptionPayment(String descriptionPayment) {
		this.descriptionPayment = descriptionPayment;
	}

	public static PaymentStatus status(Integer code) {
		if (code == null) {
			return null;
		}

		for (PaymentStatus payment : PaymentStatus.values()) {
			if (code.equals(payment.getPaymentStatus())) {
				return payment;
			}
		}

		throw new IllegalArgumentException("Código inválido: ID = " + code);
	}

}