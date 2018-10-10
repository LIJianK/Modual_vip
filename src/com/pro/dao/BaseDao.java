package com.pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
	public void exeSql(Connection conn ,String sql ,Object param [])throws Exception {
		PreparedStatement pre = null ;
		pre = conn.prepareStatement(sql);
		if(param!=null){
			for(int i = 0;i<param.length;i++){
				pre.setObject(i+1, param[i]);
			}
		}
		pre.executeUpdate();
	}
	
	public ResultSet getRs (Connection conn ,String sql ,Object param[]) throws Exception {
		PreparedStatement pre = null ;
		pre = conn.prepareStatement(sql);
		if(param!=null){
			for(int i = 0;i<param.length;i++){
				pre.setObject(i+1, param[i]);
			}
		}
		ResultSet rs = null;
		rs = pre.executeQuery();
		return rs;
		
	}
	
	
	public int getTotalRecord(Connection conn ,String sql , Object param[]) throws Exception {
		ResultSet rs  = this.getRs(conn, sql,param);
		int n =0;
		while(rs.next()){
			n = rs.getInt(1);
		}
		return n;
		
	}

}
