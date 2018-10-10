package com.pro.domain;

public class ActiveDetail {
	
	private int activeDetailId;
	
	private ActiveSet activeSet;
	
	private int rechargePrice;
	
	private int sendIntegral;

	public int getActiveDetailId() {
		return activeDetailId;
	}

	public void setActiveDetailId(int activeDetailId) {
		this.activeDetailId = activeDetailId;
	}

	public ActiveSet getActiveSet() {
		return activeSet;
	}

	public void setActiveSet(ActiveSet activeSet) {
		this.activeSet = activeSet;
	}

	public int getRechargePrice() {
		return rechargePrice;
	}

	public void setRechargePrice(int rechargePrice) {
		this.rechargePrice = rechargePrice;
	}

	public int getSendIntegral() {
		return sendIntegral;
	}

	public void setSendIntegral(int sendIntegral) {
		this.sendIntegral = sendIntegral;
	}
	
}
