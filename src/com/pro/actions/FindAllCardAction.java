package com.pro.actions;

import java.util.List;

import com.pro.domain.Card;
import com.pro.service.CardService;
import com.pro.service.CardServiceImpl;

public class FindAllCardAction extends BaseAction {

	public String findAllCard(){
		
		CardService cardService = new CardServiceImpl();
		List<Card> cardList = cardService.findAllCard();
		
		request.setAttribute("cardList", cardList);
		
		return "success";
	}
}
