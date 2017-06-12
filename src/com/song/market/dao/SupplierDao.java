package com.song.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.song.market.model.Supplier;
import com.song.market.utils.JdbcUtils;

public class SupplierDao {
	Connection conn = JdbcUtils.getConnection();
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet res;
	List<Supplier> list;
	Supplier sp ;
	public List<Supplier> getDate(String sql){
		list = new ArrayList<Supplier>();
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while(res.next()){
				sp = new Supplier();
				sp.setSpUUID(res.getString("sp_uuid"));
				sp.setSpId(res.getString("sp_id"));
				sp.setSpName(res.getString("sp_name"));
				sp.setSpDescription(res.getString("sp_description"));
				sp.setSpPhone(res.getString("sp_phone"));
				sp.setSpAddress(res.getString("sp_address"));
				sp.setSpContacts(res.getString("sp_contacts"));
				list.add(sp);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn, stmt, res);
		}

		return list;
		
	}
	public int add(String sql, Supplier sp2) {
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sp2.getSpUUID());
			pstmt.setString(2, sp2.getSpId());
			pstmt.setString(3, sp2.getSpName());
			pstmt.setString(4, sp2.getSpDescription());
			pstmt.setString(5, sp2.getSpContacts());
			pstmt.setString(6, sp2.getSpPhone());
			pstmt.setString(7, sp2.getSpAddress());
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public int modify(String sql, Supplier sp2) {
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, sp2.getSpId());
			pstmt.setString(2, sp2.getSpName());
			pstmt.setString(3, sp2.getSpDescription());
			pstmt.setString(4, sp2.getSpContacts());
			pstmt.setString(5, sp2.getSpPhone());
			pstmt.setString(6, sp2.getSpAddress());
			pstmt.setString(7, sp2.getSpUUID());
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	public List<Supplier> comqury(String sql) {
		list = new ArrayList<Supplier>();
		try {
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			 
			while(res.next()){
				sp = new Supplier();
				sp.setSpUUID(res.getString("sp_uuid"));
				sp.setSpId(res.getString("sp_id"));
				sp.setSpName(res.getString("sp_name"));
				sp.setSpDescription(res.getString("sp_description"));
				sp.setSpPhone(res.getString("sp_phone"));
				sp.setSpAddress(res.getString("sp_address"));
				sp.setSpContacts(res.getString("sp_contacts"));
				list.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int del(String ids) {
		String[] id = ids.substring(1).split(";");
		int num = 0;
		try {
			stmt = conn.createStatement();
			for(int i =0 ;i<id.length;i++){
				String sql = "delete from supplier where sp_uuid='"+id[i]+"'";
				if(stmt.executeUpdate(sql)==1){
					num++;
				};
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn, pstmt, res);
		}
		return num;
	}
	
}
