package com.song.market.model;

public class Supplier {
	private String spUUID;
	private String spId;
	private String spName;
	private String spDescription;
	private String spContacts;
	private String spPhone;
	private String spAddress;
	
	public Supplier(String spUUID, String spId, String spName,
			String spDescription, String spContacts, String spPhone,
			String spAddress) {
		super();
		this.spUUID = spUUID;
		this.spId = spId;
		this.spName = spName;
		this.spDescription = spDescription;
		this.spContacts = spContacts;
		this.spPhone = spPhone;
		this.spAddress = spAddress;
	}
	public String getSpUUID() {
		return spUUID;
	}
	public void setSpUUID(String spUUID) {
		this.spUUID = spUUID;
	}
	public String getSpId() {
		return spId;
	}
	public void setSpId(String spId) {
		this.spId = spId;
	}
	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public String getSpDescription() {
		return spDescription;
	}
	public void setSpDescription(String spDescription) {
		this.spDescription = spDescription;
	}
	public String getSpContacts() {
		return spContacts;
	}
	public void setSpContacts(String spContacts) {
		this.spContacts = spContacts;
	}
	public String getSpPhone() {
		return spPhone;
	}
	public void setSpPhone(String spPhone) {
		this.spPhone = spPhone;
	}
	public String getSpAddress() {
		return spAddress;
	}
	public void setSpAddress(String spAddress) {
		this.spAddress = spAddress;
	}
	public Supplier(String spId, String spName, String spDescription,
			String spContacts, String spPhone, String spAddress) {
		super();
		this.spId = spId;
		this.spName = spName;
		this.spDescription = spDescription;
		this.spContacts = spContacts;
		this.spPhone = spPhone;
		this.spAddress = spAddress;
	}
	public Supplier() {
		super();
	}
	
}
