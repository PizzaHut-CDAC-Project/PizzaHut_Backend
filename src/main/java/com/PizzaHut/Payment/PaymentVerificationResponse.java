package com.PizzaHut.Payment;

public  class PaymentVerificationResponse {
    public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	private boolean success;


    public PaymentVerificationResponse(boolean success) {
      this.success = success;
    }
  }