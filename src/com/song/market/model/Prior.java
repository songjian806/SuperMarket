package com.song.market.model;

public class Prior {
	private String uid;
	private String prior;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPrior() {
		return prior;
	}
	public void setPrior(String prior) {
		this.prior = prior;
	}
	public Prior(String uid, String prior) {
		super();
		this.uid = uid;
		this.prior = prior;
	}
	public Prior() {
		super();
	}
	
}
