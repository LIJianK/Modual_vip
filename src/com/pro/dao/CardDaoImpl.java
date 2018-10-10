package com.pro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pro.domain.ActiveDetail;
import com.pro.domain.ActiveSet;
import com.pro.domain.Card;
import com.pro.domain.CardStatus;

public class CardDaoImpl extends BaseDao implements CardDao {

	@Override
	public ActiveSet getActiveSet(Connection conn) throws Exception {
		
		String sql = "select * from V_ACTIVESET at where (select sysdate from dual)>at.ACTIVE_BEGIN and (select sysdate from dual)<at.ACTIVE_END";
		Object param[] = {};
		ResultSet rs = this.getRs(conn, sql, param);
		ActiveSet activeSet = null;
		if(rs.next()){
			activeSet = new ActiveSet();
			activeSet.setActiveSetId(rs.getInt("ACTIVE_ID"));
		}
		return activeSet;
	}

	@Override
	public ActiveDetail findActiveDetailByActiveSetId(Connection conn,int activeSetId)
			throws Exception {

		String sql = "select * from V_ACTIVEDETAIL where ACTIVE_ID=?";
		Object param[] = {activeSetId};
		ResultSet rs = this.getRs(conn, sql, param);
		ActiveDetail activeDetail = null;
		if(rs.next()){
			activeDetail = new ActiveDetail();
			activeDetail.setRechargePrice(rs.getInt("RECHARGE_PRICE"));
			activeDetail.setSendIntegral(rs.getInt("SEND_INTEGRAL"));
		}
		
		return activeDetail;
	}

	@Override
	public void updateCard(Connection conn, int rechargePrice, int sendIntegral2,int cardId) throws Exception {
		String sql = "update V_CARD cd set cd.CARD_INTEGRAL=cd.CARD_INTEGRAL+?,cd.CARD_BALANCE=cd.CARD_BALANCE+? where cd.CARD_ID=?";
		Object param[] = {rechargePrice,sendIntegral2,cardId};
		this.exeSql(conn, sql, param);		
	}

	@Override
	public void addIntegralRecord(Connection conn, int cardId, int rechargePrice)
			throws Exception {

		String sql = "insert into V_RECHARGE_RECORD(RECHARGE_ID,CARD_ID,RECHARGE_PRICE,RECHARGE_TIME) values(Seq_recharge_record.nextval,?,?,sysdate)";
		Object param[] = {cardId,rechargePrice};
		this.exeSql(conn, sql, param);
		
	}

	@Override
	public int findCardStatusId(Connection conn, int cardId) throws Exception {
		String sql ="select cs.CARD_VALUE from V_CARD_STATUS cs,V_CARD cd where cs.CARD_STATUS_ID=cd.CARD_STATUS_ID and cd.CARD_ID=?";
		Object param[] = {cardId};
		ResultSet rs = this.getRs(conn, sql, param);
		int cardStatusValue = -1;
		if(rs.next()){
			cardStatusValue = rs.getInt(1);
		}
		
		return cardStatusValue;
		
	}

	/**
	 * 开卡
	 */
	@Override
	public Card enableCard(Connection conn) throws Exception {
		
		String sql ="select * from V_CARD cd,V_CARD_STATUS cs where cd.CARD_STATUS_ID=3 and cd.CARD_STATUS_ID=cs.CARD_STATUS_ID and rownum<=1";
		Object param[] = {};
		ResultSet rs = this.getRs(conn, sql, param);
		Card card = null;
		if(rs.next()){
			card = new Card();
			card.setCardId(rs.getInt("CARD_ID"));
			card.setCustomerName(rs.getString("CUSTOMER_NAME"));
		}
		
		return card;
	}

	@Override
	public void updatEnableCard(Connection conn, Card card) throws Exception {

		String sql = "update V_CARD cd set cd.CUSTOMER_NAME=?,cd.CARD_STATUS_ID=2,cd.CARD_CREATE_DATE=sysdate,cd.CARD_END_DATE=sysdate where cd.CARD_ID=?";
		Object param[] = {card.getCustomerName(),card.getCardId()};
		this.exeSql(conn, sql, param);
	}

	@Override
	public void reportTheLoss(Connection conn, int cardId) throws Exception {
		
		String sql = "update V_CARD cd set cd.CARD_STATUS_ID=1 where cd.CARD_ID=?";
		Object param[] = {cardId};
		this.exeSql(conn, sql, param);
	}

	@Override
	public void liftBan(Connection conn, int cardId) throws Exception {

		String sql = "update V_CARD cd set cd.CARD_STATUS_ID=2 where cd.CARD_ID=?";
		Object param[] = {cardId};
		this.exeSql(conn, sql, param);
	}

	@Override
	public void cancellation(Connection conn, Card card) throws Exception {
		
		String sql = "update V_CARD cd set cd.CUSTOMER_NAME=(to_char(sysdate,'yyyyMMDD')),cd.CARD_STATUS_ID=3,cd.CARD_CREATE_DATE=sysdate,cd.CARD_END_DATE=sysdate,cd.CARD_BALANCE=0,cd.CARD_INTEGRAL=0 where cd.CUSTOMER_NAME=? and cd.CARD_ID=?";
		Object param[] = {card.getCustomerName(),card.getCardId()};
		this.exeSql(conn, sql, param);
	}

	@Override
	public void addIntegralRecord_Real(Connection conn, int cardId,
			int activeSetId) throws Exception {

		String sql = "insert into V_INTEGRAL_RECORD(RETEGRAL_ID,CARD_ID,ACTIVE_ID) values(Seq_integral_record.nextval,?,?)";
		Object param[] = {cardId,activeSetId};
		this.exeSql(conn, sql, param);
	}

	@Override
	public Card findCardExist(Connection conn, Card card) throws Exception {

		String sql ="select * from V_CARD where CARD_ID=? and CUSTOMER_NAME=?";
		Object param[] = {card.getCardId(),card.getCustomerName()};
		ResultSet rs = this.getRs(conn, sql, param);
		Card cd = null;
		if(rs.next()){
			cd = new Card();
			cd.setCardId(rs.getInt("CARD_ID"));
			cd.setCustomerName(rs.getString("CUSTOMER_NAME"));
		}
		return cd;
	}

	@Override
	public Card findCardAllInformation(Connection conn, int cardId)
			throws Exception {
		
		String sql ="select * from V_CARD where CARD_ID=?";
		Object param[] = {cardId};
		ResultSet rs = this.getRs(conn, sql, param);
		Card cd = null;
		if(rs.next()){
			cd = new Card();
			cd.setCardId(rs.getInt("CARD_ID"));
			cd.setIntegral(rs.getInt("CARD_INTEGRAL"));
			cd.setBalance(rs.getInt("CARD_BALANCE"));
			cd.setCardStatus(new CardStatus(rs.getInt("CARD_STATUS_ID")));
			cd.setCreateDate(rs.getDate("CARD_CREATE_DATE"));
			cd.setCustomerName(rs.getString("CUSTOMER_NAME"));
			cd.setEndDate(rs.getDate("CARD_END_DATE"));
		}
		return cd;
	}

	@Override
	public List<Card> findAllCard(Connection conn) throws Exception {
		
		String sql ="select * from V_CARD";
		Object param[] = {};
		ResultSet rs = this.getRs(conn, sql, param);
		Card cd = null;
		List<Card> cardList = new ArrayList<Card>();
		while(rs.next()){
			cd = new Card();
			cd.setCardId(rs.getInt("CARD_ID"));
			cd.setIntegral(rs.getInt("CARD_INTEGRAL"));
			cd.setBalance(rs.getInt("CARD_BALANCE"));
			cd.setCardStatus(new CardStatus(rs.getInt("CARD_STATUS_ID")));
			cd.setCreateDate(rs.getDate("CARD_CREATE_DATE"));
			cd.setCustomerName(rs.getString("CUSTOMER_NAME"));
			cd.setEndDate(rs.getDate("CARD_END_DATE"));
			cardList.add(cd);
		}
		return cardList;
	}

}
