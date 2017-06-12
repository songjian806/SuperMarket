package com.song.market.control;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.song.market.model.Supplier;
import com.song.market.service.SupplierService;

public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SupplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		if("add".equals(action)){
			add(request,response);
		}else if("modify".equals(action)){
			modify(request,response);
		}else if("comqury".equals(action)){
			comqury(request,response);
		}else if("del".equals(action)){
			del(request,response);
		}else if("imassage".equals(action)){
			response.sendRedirect("providerAdmin.jsp");
		}else{
			show(request,response);
		}				
	}

	private void del(HttpServletRequest request, HttpServletResponse response) {
		String ids = request.getParameter("id");
		SupplierService spService = new SupplierService();
		int num = spService.del(ids);
		if(num>0){
			try {
				response.getWriter().write("OK");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				response.getWriter().write("NO");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}


	private void comqury(HttpServletRequest request,
			HttpServletResponse response) {
		String providerName = request.getParameter("providerName");
		String providerDesc = request.getParameter("providerDesc");
		String sql = "select * from supplier where sp_name='"+providerName+"' AND sp_description='"+providerDesc+"'";
		SupplierService spService = new SupplierService();
		List<Supplier> spList = spService.comqury(sql);
		String s = JSON.toJSONString(spList);
		try {
			response.getWriter().write(s);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void modify(HttpServletRequest request, HttpServletResponse response) {		
		String spUuid = request.getParameter("spUuid");
		String spId = request.getParameter("spId");
		String spName = request.getParameter("spName");
		String spDescription = request.getParameter("spDescription");
		String spContacts = request.getParameter("spContacts");
		String spPhone = request.getParameter("spPhone");
		String spAddress = request.getParameter("spAddress");
		Supplier sp = new Supplier(spUuid, spId, spName, spDescription, spContacts, spPhone, spAddress);
		String sql = "update supplier set sp_id=?,sp_name=?,sp_description=?,"
				+ "sp_contacts=?,sp_phone=?,sp_address=? where sp_uuid=?";
		SupplierService spService = new SupplierService();
		int num = spService.modify(sql,sp);
		request.setAttribute("tips", num>0?"修改成功":"修改失败");
		try {
			request.getRequestDispatcher("sp_imassage.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void add(HttpServletRequest request, HttpServletResponse response) {
		String spUUID = UUID.randomUUID().toString().replaceAll("-", "");
		String spId = request.getParameter("spId");
		String spName = request.getParameter("spName");
		String spDescription = request.getParameter("spDescription");
		String spContacts = request.getParameter("spContacts");
		String spPhone = request.getParameter("spPhone");
		String spAddress = request.getParameter("spAddress");
		Supplier sp = new Supplier(spUUID,spId, spName, spDescription, spContacts, spPhone, spAddress);
		
		String sql = "insert into supplier values(?,?,?,?,?,?,?)";
		SupplierService spService = new SupplierService();
		int num;
		num = spService.add(sql,sp);
		request.setAttribute("tips", num>0?"添加成功":"添加失败");
		try {
			request.getRequestDispatcher("sp_imassage.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void show(HttpServletRequest request, HttpServletResponse response) {
		SupplierService spService = new SupplierService();
		List<Supplier> list = spService.getDate();
		String s = JSON.toJSONString(list);
		try {
			response.getWriter().write(s);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
