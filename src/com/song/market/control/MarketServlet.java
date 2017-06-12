package com.song.market.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.song.market.model.Bill;
import com.song.market.service.MarketService;


public class MarketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String option = request.getParameter("action");
		if("add".equals(option)){
			add(request, response);
		}else if("search".equals(option)){
			search(request, response);
		}else if("del".equals(option)){
			del(request, response);
		}else if("modify".equals(option)){
			modify(request, response);
		}else if("login".equals(option)){
			login(request, response);
		}else if("show".equals(option)){
			show(request, response);
		}else if("imassage".equals(option)){
			response.sendRedirect("admin_bill_list.jsp");
		}else if("exit".equals(option)){
			exit(request, response);
		}
		else{
			response.sendRedirect("login.jsp");
		}			
	}

	private void exit(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		try {
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("userName").trim();
		String password = request.getParameter("passWord").trim();
		String sql = "select * from user where username='"+username+"' AND password='"+password+"'";
		MarketService mkService = new MarketService();
		int num = mkService.login(sql);
		if(num>0){
			request.getSession().setAttribute("username",username);
			request.setAttribute("password", password);			
			try {
				request.getRequestDispatcher("admin_index.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	private void modify(HttpServletRequest request,
			HttpServletResponse response) {
		String uid = request.getParameter("uid").trim();
		String goodName = request.getParameter("goodName").trim();
		int goodSum = Integer.parseInt(request.getParameter("goodSum").trim());
		String billNum = request.getParameter("billNum").trim();
		String billTime = request.getParameter("billTime").trim();
		String suppliers = request.getParameter("suppliers").trim();
		double money = Double.parseDouble(request.getParameter("money").trim());
		String discription = request.getParameter("discription").trim();
		boolean isPay =Boolean.parseBoolean(request.getParameter("isPay").trim());
		Bill bill = new Bill(uid, billNum, goodName, goodSum, money, isPay, suppliers, discription, billTime);
		
		String sql = "update bill set bill_no=?,bill_name=?,bill_goods_sum=?,"
				+ "bill_trade_money=?,bill_ispay=?,bill_suppliers_name=?,"
				+ "bill_goods_description=?,bill_time=? where bill_uid=? ";
			
		MarketService mkService = new MarketService();
		int num = mkService.updataAfter(sql,bill);
		
		 request.setAttribute("tips", num>0?"修改成功":"修改失败");
	        try {
				request.getRequestDispatcher("imassage.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
	}

	private void del(HttpServletRequest request, HttpServletResponse response) {
		String uuid = request.getParameter("id").trim();
		MarketService ms = new MarketService();
		String sql = uuid.substring(1, uuid.length()-1);
		int num = ms.del(sql);
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

	private void search(HttpServletRequest request,
			HttpServletResponse response) {
		String productName = request.getParameter("productName").trim();
		int payStatus = Integer.parseInt(request.getParameter("payStatus").trim());
		String sql = "select * from bill where bill_name='"+productName+
		"'AND bill_ispay='"+payStatus+"'";
		MarketService ms = new MarketService();
		List<Bill> listBill = ms.cominQuryBill(sql);		
		if(listBill.size()>0){
			String s = JSON.toJSONString(listBill);
			try {
				response.getWriter().write(s);
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
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


	private void add(HttpServletRequest request, HttpServletResponse response) {
		String uid = UUID.randomUUID().toString().replace("-", "");
		String goodName =  request.getParameter("goodName").trim();
		String goodSum = request.getParameter("goodSum").trim();
		int billNum =  Integer.parseInt(request.getParameter("billNum").trim());
		double money =  Double.parseDouble(request.getParameter("money").trim());
		String discription =  request.getParameter("discription").trim();
		int isPay =  Integer.parseInt(request.getParameter("isPay").trim());
		String suppliers =  request.getParameter("suppliers").trim();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String data = df.format(new Date());
		MarketService ms = new MarketService();
        String sql = "insert into bill values ('"+uid+"','"+billNum+"','"+goodName+"','"+goodSum+"','"+money+"','"+isPay+"','"
        		+ suppliers+"','"+discription+"','"+data+"')";
        int num = ms.addBill(sql);
        request.setAttribute("tips", num>0?"添加成功":"添加失败");
        try {
			request.getRequestDispatcher("imassage.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};		
	}

	private void show(HttpServletRequest request, HttpServletResponse response) {
		MarketService ms = new MarketService();
		List<Bill> list = ms.getBillData();
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
