package com.song.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.song.market.model.Bill;
import com.song.market.utils.JdbcUtils;

public class MarketDao {
	Connection conn = JdbcUtils.getConnection();
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	public List<Bill> getBillData(String sql){
		
		List<Bill> billList = new ArrayList<Bill>();
		ResultSet res = null;
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while(res.next()){
				Bill bill = new Bill();
				bill.setUid(res.getString("bill_uid"));
				bill.setNo(res.getString("bill_no"));
				bill.setName(res.getString("bill_name"));
				bill.setGoodSum(Integer.parseInt(res.getString("bill_goods_sum")));
				bill.setTradeMoney(Double.parseDouble(res.getString("bill_trade_money")));
				bill.setPay((Integer.parseInt(res.getString("bill_ispay")))>0?true:false);
				bill.setSuppliersName(res.getString("bill_suppliers_name"));
				bill.setGoodsDescription(res.getString("bill_goods_description"));
				bill.setTime(res.getString("bill_time"));
				billList.add(bill);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn, stmt, res);
		}
		
		return billList;
		
	}

	public int addBill(String sql) {
		int num = 0;
		try {
			stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
		
	}

	public List<Bill> cominQuryBill(String sql) {
		List<Bill> billList = new ArrayList<Bill>();
		ResultSet res = null;
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while(res.next()){
				Bill bill = new Bill();
				bill.setUid(res.getString("bill_uid"));
				bill.setNo(res.getString("bill_no"));
				bill.setName(res.getString("bill_name"));
				bill.setGoodSum(Integer.parseInt(res.getString("bill_goods_sum")));
				bill.setTradeMoney(Double.parseDouble(res.getString("bill_trade_money")));
				bill.setPay((Integer.parseInt(res.getString("bill_ispay")))>0?true:false);
				bill.setSuppliersName(res.getString("bill_suppliers_name"));
				bill.setGoodsDescription(res.getString("bill_goods_description"));
				bill.setTime(res.getString("bill_time"));
				billList.add(bill);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return billList;
	}

	public int del(String sql) {
		int num = 0,index = 0;
		String[] sq2 = sql.split(";");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i<sq2.length;i++){
			String sq3 = "delete from bill where bill_uid='"+sq2[i]+"'";
			try {
				num = stmt.executeUpdate(sq3);
				index+=num;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		return index;
	}

	public List<Bill> updataBill(String sql) {
		List<Bill> billList = new ArrayList<Bill>();
		ResultSet res = null;
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while(res.next()){
				Bill bill = new Bill();
				bill.setUid(res.getString("bill_uid"));
				bill.setNo(res.getString("bill_no"));
				bill.setName(res.getString("bill_name"));
				bill.setGoodSum(Integer.parseInt(res.getString("bill_goods_sum")));
				bill.setTradeMoney(Double.parseDouble(res.getString("bill_trade_money")));
				bill.setPay((Integer.parseInt(res.getString("bill_ispay")))>0?true:false);
				bill.setSuppliersName(res.getString("bill_suppliers_name"));
				bill.setGoodsDescription(res.getString("bill_goods_description"));
				bill.setTime(res.getString("bill_time"));
				billList.add(bill);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return billList;
	}

	public int updataAfter(String sql,Bill bill) {
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bill.getNo());
			pstmt.setString(2, bill.getName());
			pstmt.setInt(3, bill.getGoodSum());
			pstmt.setDouble(4, bill.getTradeMoney());
			pstmt.setBoolean(5, bill.isPay());
			pstmt.setString(6, bill.getSuppliersName());
			pstmt.setString(7, bill.getGoodsDescription());
			pstmt.setString(8, bill.getTime());
			pstmt.setString(9, bill.getUid());
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	public int login(String sql) {
		int num = 0;
		ResultSet res = null;
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			if(res.next()){
				num = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return num;
	}
	
}
