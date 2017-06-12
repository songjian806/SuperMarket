package com.song.market.model;

public class Bill {
	
	private String uid;
	private String no;
	private String name;
	private int goodSum;
	private double tradeMoney;
	private boolean isPay;
	private String suppliersName;
	private String goodsDescription;
	private String time;
	public Bill(String uid, String no, String name, int goodSum,
			double tradeMoney, boolean isPay, String suppliersName,
			String goodsDescription, String time) {
		super();
		this.uid = uid;
		this.no = no;
		this.name = name;
		this.goodSum = goodSum;
		this.tradeMoney = tradeMoney;
		this.isPay = isPay;
		this.suppliersName = suppliersName;
		this.goodsDescription = goodsDescription;
		this.time = time;
	}
	public Bill() {
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGoodSum() {
		return goodSum;
	}
	public void setGoodSum(int goodSum) {
		this.goodSum = goodSum;
	}
	public double getTradeMoney() {
		return tradeMoney;
	}
	public void setTradeMoney(double tradeMoney) {
		this.tradeMoney = tradeMoney;
	}
	public boolean isPay() {
		return isPay;
	}
	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}
	public String getSuppliersName() {
		return suppliersName;
	}
	public void setSuppliersName(String suppliersName) {
		this.suppliersName = suppliersName;
	}
	public String getGoodsDescription() {
		return goodsDescription;
	}
	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
