package com.pro.actions;


import com.pro.domain.Card;
import com.pro.service.CardService;
import com.pro.service.CardServiceImpl;

public class FindSingleCardAction extends BaseAction {

	private Card card;

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String findSingleCard(){
		
		CardService cardService = new CardServiceImpl();
		Card cd = cardService.findSingleCard(card.getCardId());
		if(cd != null){
			request.setAttribute("cd", cd);
		}else{
		}
		
		return "success";
	}
}
