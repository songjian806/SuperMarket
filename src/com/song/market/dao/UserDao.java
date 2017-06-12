package com.song.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.song.market.model.Prior;
import com.song.market.model.User;
import com.song.market.utils.JdbcUtils;

public class UserDao {
	Connection conn = JdbcUtils.getConnection();
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet res;
	List<User> list;
	User user ;
	public List<User> getDate(String sql){
		list = new ArrayList<User>();
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while(res.next()){
				user = new User();
				user.setUserUuid(res.getString("user_uuid"));
				user.setUserId(res.getString("user_id"));
				user.setUserName(res.getString("username"));
				user.setPassword(res.getString("password"));
				user.setUserSex(res.getString("user_sex"));
				user.setUserAge(res.getString("user_age"));
				user.setUserPhone(res.getString("user_phone"));
				user.setUserAddress(res.getString("user_address"));
				user.setPrior(res.getString("user_prior"));
				list.add(user);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn, stmt, res);
		}

		return list;
		
	}
	public int add(List list2, String[] sql) {
		User user = (User) list2.get(0);
		Prior prior = (Prior) list2.get(1);
		String sql1 = sql[0];
		String sql2 = sql[1];
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, user.getUserUuid());
			pstmt.setString(2, user.getUserId());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getUserSex());
			pstmt.setString(6, user.getUserAge());
			pstmt.setString(7, user.getUserPhone());
			pstmt.setString(8, user.getUserAddress());
			if(pstmt.executeUpdate()>0){
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, prior.getUid());
				pstmt.setString(2, prior.getPrior());
				num = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public int del(String ids) {
		int num = 0;
		String[] id = ids.substring(1).split(";");
		for(int i =0;i<id.length;i++){
			String sql1 = "delete from user where user_uuid='"+id[i]+"'";
			String sql2 = "DELETE FROM prior WHERE user_id = ("+
					      "SELECT * FROM ("+
		                  "SELECT p.user_id FROM USER u,prior p WHERE"
		                  + " u.user_id=p.user_id AND user_uuid='"+id[i]+"')a"+
                          ")";
			try {
				stmt = conn.createStatement();
				if(stmt.executeUpdate(sql2)>0){
					num = stmt.executeUpdate(sql1);			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return num;
	}
	public int modify(List list2, String[] sql) {
		User user = (User) list2.get(0);
		Prior prior = (Prior) list2.get(1);
		String sql1 = sql[0];
		String sql2 = sql[1];
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql1);		
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getUserSex());
			pstmt.setString(5, user.getUserAge());
			pstmt.setString(6, user.getUserPhone());
			pstmt.setString(7, user.getUserAddress());
			pstmt.setString(8, user.getUserUuid());
			if(pstmt.executeUpdate()>0){
				pstmt = conn.prepareStatement(sql2);				
				pstmt.setString(1, prior.getPrior());
				pstmt.setString(2, prior.getUid());
				num = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	public List<User> search(String sql, String userName) {
		list = new ArrayList<User>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			res =  pstmt.executeQuery();
			while(res.next()){
				user = new User();
				user.setUserUuid(res.getString("user_uuid"));
				user.setUserId(res.getString("user_id"));
				user.setUserName(res.getString("username"));
				user.setPassword(res.getString("password"));
				user.setUserSex(res.getString("user_sex"));
				user.setUserAge(res.getString("user_age"));
				user.setUserPhone(res.getString("user_phone"));
				user.setUserAddress(res.getString("user_address"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
