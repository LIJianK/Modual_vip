package com.pro.actions;

import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSON;
import com.pro.domain.Card;
import com.pro.service.CardService;
import com.pro.service.CardServiceImpl;

public class UpdatEnableCardAction extends BaseAction {
	
	private String cardIDAndName;

	public String getCardIDAndName() {
		return cardIDAndName;
	}

	public void setCardIDAndName(String cardIDAndName) {
		this.cardIDAndName = cardIDAndName;
	}
	
	public String updatEnableCard(){
		
		Card card = JSON.parseObject(cardIDAndName,Card.class);
		
		CardService cardService = new CardServiceImpl();
		cardService.updatEnableCard(card);
		
		//查V_CARD表，得到信息
		Card cd = cardService.findCardAllInformation(card.getCardId());
		String info = "开卡成功！\n卡号："+card.getCardId()+"\n积分余额："+cd.getIntegral()+"\n账户余额："+cd.getBalance()+"\n创建时间："+cd.getCreateDate()+"\n姓名："+cd.getCustomerName();
		
		response.setCharacterEncoding("utf-8");
		PrintWriter writer;
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
