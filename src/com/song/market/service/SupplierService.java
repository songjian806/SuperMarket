package com.song.market.service;

import java.util.List;

import com.song.market.dao.SupplierDao;
import com.song.market.model.Supplier;

public class SupplierService {
	public List<Supplier> getDate(){
		String sql = "select * from supplier";
		SupplierDao spDao = new SupplierDao();
		List<Supplier> list = spDao.getDate(sql);		
		return list;		
	}

	public int add(String sql, Supplier sp) {
		SupplierDao spDao = new SupplierDao();
		
		return spDao.add(sql,sp);
	}

	public int modify(String sql, Supplier sp) {
		SupplierDao spDao = new SupplierDao();
		return spDao.modify(sql,sp);
	}

	public List<Supplier> comqury(String sql) {
		SupplierDao spDao = new SupplierDao();
		return spDao.comqury(sql);
	}

	public int del(String ids) {
		SupplierDao spDao = new SupplierDao();
		return spDao.del(ids);
	}
}
