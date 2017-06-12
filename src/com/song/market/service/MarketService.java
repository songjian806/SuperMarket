package com.song.market.service;

import java.util.List;

import com.song.market.dao.MarketDao;
import com.song.market.model.Bill;

public class MarketService {
	
	public List<Bill>  getBillData(){
		
		MarketDao md = new MarketDao();
		String sql = "select * from bill";
		List<Bill> billList = md.getBillData(sql);
		return billList;
		
	}

	public int addBill(String sql) {
		MarketDao md = new MarketDao();
		return md.addBill(sql);
		
	}

	public List<Bill> cominQuryBill(String sql) {
		MarketDao md = new MarketDao();
		return md.cominQuryBill(sql);
	}

	public int del(String sql) {
		MarketDao md = new MarketDao();
		return md.del(sql);
	}

	public List<Bill> updataBill(String sql) {
		MarketDao md = new MarketDao();
		List<Bill> billList = md.updataBill(sql);
		return billList;
	}

	public int updataAfter(String sql,Bill bill) {
		MarketDao md = new MarketDao();
		return md.updataAfter(sql,bill);
	}

	public int login(String sql) {
		MarketDao md = new MarketDao();
		return md.login(sql);
	}
	
}
