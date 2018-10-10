package com.pro.actions;

import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSON;
import com.pro.domain.Card;
import com.pro.service.CardService;
import com.pro.service.CardServiceImpl;

public class ThawAction extends BaseAction {

	private String cardIDAndName;

	public String getCardIDAndName() {
		return cardIDAndName;
	}

	public void setCardIDAndName(String cardIDAndName) {
		this.cardIDAndName = cardIDAndName;
	}
	
	public String thaw(){
		

		Card card = JSON.parseObject(cardIDAndName,Card.class);
		int cardId = card.getCardId();
		
		String info = "";
		CardService cardService = new CardServiceImpl();
		Card cd = cardService.findCardExist(card);
		//查是否用户名与卡号是否相同
		if(cd != null){
			//查到==》判断卡的状态
			
			//判断该卡是否被禁用
			int cardStatusValue = cardService.findCardStatusId(cardId);
			if(cardStatusValue == 0){
				cardService.liftBan(cardId);
				info = "成功解冻！";
			}else if(cardStatusValue == 1){
				info = "非法操作：此卡已能正常使用";
			}
			
		}else{
			info = "请正确输入卡号与姓名！";
		}
		
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
