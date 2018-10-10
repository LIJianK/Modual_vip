package com.pro.domain;

import java.sql.Date;

public class RechargeRecord {

	private int rechargeId;
	
	private int cardId;
	
	private int rechargePrice;
	
	private Date rechargeTime;

	public int getRechargeId() {
		return rechargeId;
	}

	public void setRechargeId(int rechargeId) {
		this.rechargeId = rechargeId;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getRechargePrice() {
		return rechargePrice;
	}

	public void setRechargePrice(int rechargePrice) {
		this.rechargePrice = rechargePrice;
	}

	public Date getRechargeTime() {
		return rechargeTime;
	}

	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	
	
}
