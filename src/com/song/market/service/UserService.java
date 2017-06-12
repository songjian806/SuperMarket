package com.song.market.service;

import java.util.List;

import com.song.market.dao.UserDao;
import com.song.market.model.User;

public class UserService {
	public List<User> getDate(){		
		UserDao ud = new UserDao();
		String sql = "select * from user u,prior p  where u.user_id=p.user_id";
		return ud.getDate(sql);		
	}

	public int add(List list) {
		UserDao ud = new UserDao();
		String[] sql = {"insert into user values(?,?,?,?,?,?,?,?)",
				"insert into prior values(?,?)"};	
		return ud.add(list,sql);
	}

	public int del(String ids) {
		UserDao ud = new UserDao();
		return ud.del(ids);
	}

	public int modify(List list) {
		UserDao ud = new UserDao();
		String[] sql = {"update user set user_id=?,username=?,"
				+ "password=?,user_sex=?,user_age=?,user_phone=?,user_address=? where user_uuid=?",
				"update prior set user_prior=? where user_id=?"};	
		return ud.modify(list,sql);
	}

	public List<User> search(String userName) {
		UserDao ud = new UserDao();
		String sql = "select * from user where username=?";
		return ud.search(sql,userName);
	}
}
