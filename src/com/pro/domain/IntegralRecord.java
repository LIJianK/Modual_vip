package com.pro.domain;

public class IntegralRecord {

	private int IntegralRecordId;
	
	private Card cardId;
	
	private IntegralType integralType;

	public int getIntegralRecordId() {
		return IntegralRecordId;
	}

	public void setIntegralRecordId(int integralRecordId) {
		IntegralRecordId = integralRecordId;
	}

	public Card getCardId() {
		return cardId;
	}

	public void setCardId(Card cardId) {
		this.cardId = cardId;
	}

	public IntegralType getIntegralType() {
		return integralType;
	}

	public void setIntegralType(IntegralType integralType) {
		this.integralType = integralType;
	}
	
}
