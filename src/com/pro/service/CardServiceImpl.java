package com.pro.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pro.dao.CardDao;
import com.pro.dao.CardDaoImpl;
import com.pro.domain.ActiveDetail;
import com.pro.domain.ActiveSet;
import com.pro.domain.Card;
import com.pro.util.DbHelper;

public class CardServiceImpl implements CardService{

	@Override
	public void recharge(int cardId, int rechargePrice) {

		Connection conn = null;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			conn.setAutoCommit(false);
			
			//1==查单当前数据库的时间
			//2==用查到的时间作为条件，去V_ACTIVESET表查出ACTIVE_ID
			ActiveSet activeSet = cardDao.getActiveSet(conn);
			int activeSetId = activeSet.getActiveSetId();
			
			//3==以ACTIVE_ID为条件，去V_ACTIVEDETAIL表查（RECHARGE_PRICE，SEND_INTEGRAL）
			ActiveDetail activeDetail = cardDao.findActiveDetailByActiveSetId(conn,activeSetId);
			//--承接上一步--	用RECHARGE_PRICE和SEND_INTEGRAL计算充值的钱（rechargePrice）得到多少积分
			int rechargePrice2 = activeDetail.getRechargePrice();
			int sendIntegral = activeDetail.getSendIntegral();
			int sendIntegral2 = rechargePrice/rechargePrice2*sendIntegral;	//获得的积分
			
			//4==修改V_CARD表中的CARD_INTEGRAL、CARD_BALANCE,根据CARD_ID
			cardDao.updateCard(conn,rechargePrice,sendIntegral2,cardId);
			
			//5==添加V_INTEGRAL_RECORD数据cardId、rechargePrice、（第一步查询得到的时间）
			cardDao.addIntegralRecord(conn,cardId,rechargePrice);
			
			//6==添加V_INTEGRAL_RECORD表中的记录，（cardId，activeSetId）
			cardDao.addIntegralRecord_Real(conn,cardId,activeSetId);
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int findCardStatusId(int cardId) {

		Connection conn = null;
		int cardStatusValue = -1;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			cardStatusValue = cardDao.findCardStatusId(conn,cardId);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cardStatusValue;
	}

	@Override
	public Card enableCard() {
		
		Connection conn = null;
		Card card = null;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			card = cardDao.enableCard(conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return card;
	}

	@Override
	public void updatEnableCard(Card card) {
		
		Connection conn = null;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			cardDao.updatEnableCard(conn,card);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void reportTheLoss(int cardId) {

		Connection conn = null;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			cardDao.reportTheLoss(conn,cardId);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void liftBan(int cardId) {

		Connection conn = null;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			cardDao.liftBan(conn,cardId);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cancellation(Card card) {

		Connection conn = null;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			cardDao.cancellation(conn,card);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Card findCardExist(Card card) {

		Connection conn = null;
		Card cd = null;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			cd = cardDao.findCardExist(conn,card);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cd;
	}

	@Override
	public int getIntegral(int cardId, int rechargePrice) {

		Connection conn = null;
		int sendIntegral2 = 0;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			ActiveSet activeSet = cardDao.getActiveSet(conn);
			int activeSetId = activeSet.getActiveSetId();
			ActiveDetail activeDetail = cardDao.findActiveDetailByActiveSetId(conn,activeSetId);
			int rechargePrice2 = activeDetail.getRechargePrice();
			int sendIntegral = activeDetail.getSendIntegral();
			sendIntegral2 = rechargePrice/rechargePrice2*sendIntegral;	//获得的积分
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sendIntegral2;
	}

	@Override
	public Card findCardAllInformation(int cardId) {
		
		Connection conn = null;
		Card card = null;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			card = cardDao.findCardAllInformation(conn,cardId);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return card;
	}

	@Override
	public ActiveDetail findOfActive() {
		
		Connection conn = null;
		ActiveDetail activeDetail = null;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			conn.setAutoCommit(false);
			
			ActiveSet activeSet = cardDao.getActiveSet(conn);
			int activeSetId = activeSet.getActiveSetId();
			
			activeDetail = cardDao.findActiveDetailByActiveSetId(conn,activeSetId);
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return activeDetail;
	}

	@Override
	public Card findSingleCard(int cardId) {

		Connection conn = null;
		Card card = null;
		
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			card = cardDao.findCardAllInformation(conn,cardId);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return card;
	}

	@Override
	public List<Card> findAllCard() {

		Connection conn = null;
		List<Card> cardList = new ArrayList<Card>();
			
		try {
			conn = DbHelper.getConn();
			CardDao cardDao = new CardDaoImpl();
			cardList = cardDao.findAllCard(conn);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				DbHelper.closeAll(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cardList;
	}
	

}
