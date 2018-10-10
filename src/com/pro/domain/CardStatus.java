package com.pro.domain;

public class CardStatus {

	private int cardStatusId;
	private int cardValue;	//0禁用,1启用,2未开卡
	
	
	public CardStatus() {
		super();
	}
	public CardStatus(int cardValue) {
		super();
		this.cardValue = cardValue;
	}
	public int getCardStatusId() {
		return cardStatusId;
	}
	public void setCardStatusId(int cardStatusId) {
		this.cardStatusId = cardStatusId;
	}
	public int getCardValue() {
		return cardValue;
	}
	public void setCardValue(int cardValue) {
		this.cardValue = cardValue;
	}
}
