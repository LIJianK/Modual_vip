package com.pro.actions;

import com.pro.domain.ActiveDetail;
import com.pro.service.CardService;
import com.pro.service.CardServiceImpl;

public class FindOfActiveAction extends BaseAction {

	public String findOfActive(){
		
		CardService cardService = new CardServiceImpl();
		ActiveDetail activeDetail = cardService.findOfActive();
		
		request.setAttribute("activeDetail", activeDetail);
		
		return "success";
	}
}
