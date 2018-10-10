package com.pro.service;

import java.util.List;

import com.pro.domain.ActiveDetail;
import com.pro.domain.Card;


public interface CardService {

	public void recharge(int cardId,int rechargePrice);

	public int findCardStatusId(int cardId);

	public Card enableCard();

	public void updatEnableCard(Card card);

	public void reportTheLoss(int cardId);

	public void liftBan(int cardId);

	public void cancellation(Card card);

	public Card findCardExist(Card card);

	public int getIntegral(int cardId, int rechargePrice);

	public Card findCardAllInformation(int cardId);

	public ActiveDetail findOfActive();

	public Card findSingleCard(int cardId);

	public List<Card> findAllCard();
}
