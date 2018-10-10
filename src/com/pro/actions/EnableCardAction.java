package com.pro.actions;

import com.pro.domain.Card;
import com.pro.service.CardService;
import com.pro.service.CardServiceImpl;


public class EnableCardAction extends BaseAction {

	public String enableCard(){
		
		//查表中 第一个 状态为 未开卡的 card Id
		CardService cardService = new CardServiceImpl();
		Card card = cardService.enableCard();
		
		request.setAttribute("card", card);
		
		
		return "success";
	}
}
