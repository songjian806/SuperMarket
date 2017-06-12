package com.song.market.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.song.market.model.Prior;
import com.song.market.model.Supplier;
import com.song.market.model.User;
import com.song.market.service.SupplierService;
import com.song.market.service.UserService;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		if("add".equals(action)){
			add(request,response);
		}else if("del".equals(action)){
			del(request,response);
		}else if("modify".equals(action)){
			modify(request,response);
		}else if("search".equals(action)){
			search(request,response);
		}else if("imassage".equals(action)){
			response.sendRedirect("userAdmin.jsp");
		}
		else{
			show(request,response);
		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName").trim();
		UserService userService = new UserService();
		List<User> list = userService.search(userName);
		if(list.size()>0){
			String s = JSON.toJSONString(list);
			try {
				response.getWriter().write(s);
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				response.getWriter().write("ERROR");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}


	private void modify(HttpServletRequest request, HttpServletResponse response) {
		String userUuid = request.getParameter("useruuid").trim();
		String userId = request.getParameter("userId").trim();
		String userName = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String userSex = request.getParameter("sex").trim();
		String userAge = request.getParameter("age").trim();
		String userPhone = request.getParameter("phone").trim();
		String userAddress = request.getParameter("address").trim();
		String auth = request.getParameter("auth").trim();
		User user = new User(userUuid, userId, userName, password, userSex, userAge, userPhone, userAddress);
		Prior prior = new Prior(userId, auth);
		List list = new ArrayList();
		list.add(user);
		list.add(prior);
		UserService userService = new UserService();
		int num = userService.modify(list);
		request.setAttribute("tips", num>0?"修改成功":"修改失败");
		try {
			request.getRequestDispatcher("user_imassage.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}


	private void del(HttpServletRequest request, HttpServletResponse response) {
		String ids = request.getParameter("id").trim();
		UserService userService = new UserService();
		int num = userService.del(ids);
		if(num>0){
			try {
				response.getWriter().write("OK");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				response.getWriter().write("No");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}	
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId").trim();
		String userName = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String userSex = request.getParameter("sex").trim();
		String userAge = request.getParameter("age").trim();
		String userPhone = request.getParameter("phone").trim();
		String userAddress = request.getParameter("address").trim();
		String auth = request.getParameter("auth").trim();
		String Uuid = UUID.randomUUID().toString().replaceAll("-", "");
		User user = new User(Uuid, userId, userName, password, userSex, userAge, userPhone, userAddress);
		Prior prior = new Prior(userId, auth);
		List list = new ArrayList();
		list.add(user);
		list.add(prior);
		UserService userService = new UserService();
		int num = userService.add(list);
		request.setAttribute("tips", num>0?"添加成功":"添加失败");
		try {
			request.getRequestDispatcher("user_imassage.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = new UserService();
		List<User> list = userService.getDate();
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
