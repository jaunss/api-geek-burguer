package com.joaogcm.api.geek.burguer.entities.enums;

public enum PaymentStatus {

	AwaitingPayment(1, "Awaiting Payment"), Pending(2, "Pending"), Settled(3, "Settled"), Canceled(4, "Canceled");

	private Integer statusPayment;
	private String descriptionPayment;

	private PaymentStatus() {

	}

	private PaymentStatus(Integer statusPayment, String descriptionPayment) {
		this.statusPayment = statusPayment;
		this.descriptionPayment = descriptionPayment;
	}

	public Integer getStatusPayment() {
		return statusPayment;
	}

	public void setStatusPayment(Integer statusPayment) {
		this.statusPayment = statusPayment;
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
			if (code.equals(payment.getStatusPayment())) {
				return payment;
			}
		}

		throw new IllegalArgumentException("Código inválido: ID = " + code);
	}

}