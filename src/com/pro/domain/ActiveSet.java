package com.pro.domain;

import java.sql.Date;

public class ActiveSet {

	private int activeSetId;
	
	private IntegralType integralType;
	
	private String activeTitle;
	
	private Date activeBegin;
	
	private Date activeEnd;

	

	public int getActiveSetId() {
		return activeSetId;
	}

	public void setActiveSetId(int activeSetId) {
		this.activeSetId = activeSetId;
	}

	public IntegralType getIntegralType() {
		return integralType;
	}

	public void setIntegralType(IntegralType integralType) {
		this.integralType = integralType;
	}

	public String getActiveTitle() {
		return activeTitle;
	}

	public void setActiveTitle(String activeTitle) {
		this.activeTitle = activeTitle;
	}

	public Date getActiveBegin() {
		return activeBegin;
	}

	public void setActiveBegin(Date activeBegin) {
		this.activeBegin = activeBegin;
	}

	public Date getActiveEnd() {
		return activeEnd;
	}

	public void setActiveEnd(Date activeEnd) {
		this.activeEnd = activeEnd;
	}
	
}
