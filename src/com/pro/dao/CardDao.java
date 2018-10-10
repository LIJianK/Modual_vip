package com.pro.dao;

import java.sql.Connection;
import java.util.List;

import com.pro.domain.ActiveDetail;
import com.pro.domain.ActiveSet;
import com.pro.domain.Card;

public interface CardDao {

	public ActiveSet getActiveSet(Connection conn)throws Exception;

	public ActiveDetail findActiveDetailByActiveSetId(Connection conn,int activeSetId)throws Exception;

	public void updateCard(Connection conn, int rechargePrice, int sendIntegral2,int cardId) throws Exception;

	public void addIntegralRecord(Connection conn, int cardId, int rechargePrice) throws Exception;

	public int findCardStatusId(Connection conn, int cardId) throws Exception;

	public Card enableCard(Connection conn)throws Exception;

	public void updatEnableCard(Connection conn, Card card)throws Exception;

	public void reportTheLoss(Connection conn, int cardId)throws Exception;

	public void liftBan(Connection conn, int cardId)throws Exception;

	public void cancellation(Connection conn, Card card)throws Exception;

	public void addIntegralRecord_Real(Connection conn, int cardId,
			int activeSetId)throws Exception;

	public Card findCardExist(Connection conn, Card card)throws Exception;

	public Card findCardAllInformation(Connection conn, int cardId)throws Exception;

	public List<Card> findAllCard(Connection conn)throws Exception;

}
