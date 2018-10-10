package com.pro.actions;

import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSON;
import com.pro.domain.Card;
import com.pro.domain.RechargeRecord;
import com.pro.service.CardService;
import com.pro.service.CardServiceImpl;

public class CardAction extends BaseAction {

	private Card card;
	private RechargeRecord rechargeRecord;
	private String demo;

	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

	public RechargeRecord getRechargeRecord() {
		return rechargeRecord;
	}

	public void setRechargeRecord(RechargeRecord rechargeRecord) {
		this.rechargeRecord = rechargeRecord;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	/**
	 *	充值 
	 * @return
	 */
	public String recharge(){
		
		RechargeRecord rechargeRecord = JSON.parseObject(demo,RechargeRecord.class);
		int cardId = rechargeRecord.getCardId();
		int rechargePrice = rechargeRecord.getRechargePrice();
		
		CardService cardService = new CardServiceImpl();
		String info = "";
		//判断该卡是否被禁用
		int cardStatusValue = cardService.findCardStatusId(cardId);
		if(cardStatusValue == 0){
			info = "此卡已被挂失";
		}else if(cardStatusValue == 1){
			//充值
			cardService.recharge(cardId, rechargePrice);
			//获得积分
			int getIntegral = cardService.getIntegral(cardId, rechargePrice);
			Card card = cardService.findCardAllInformation(cardId);
			//积分余额
			
			//账户余额
			info = "充值成功\n获得积分："+getIntegral+"\n积分余额："+card.getIntegral()+"\n账户余额："+card.getBalance();
		}else if(cardStatusValue == 2){
			info = "未开卡";
		}else{
			info = "请输入正确卡号";
		}
		
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(info);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
