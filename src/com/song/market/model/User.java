package com.song.market.model;

public class User {
	
	private String userUuid;
	private String userId;
	private String userName;
	private String password;
	private String userSex;
	private String userAge;
	private String userPhone;
	private String prior;
	
	public String getPrior() {
		return prior;
	}
	public void setPrior(String prior) {
		this.prior = prior;
	}
	public User(String userUuid, String userId, String userName,
			String password, String userSex, String userAge, String userPhone,
			String userAddress) {
		super();
		this.userUuid = userUuid;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}
	public User(String userUuid, String userId, String userName,
			String password, String userSex, String userAge, String userPhone,
			String prior, String userAddress) {
		super();
		this.userUuid = userUuid;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userPhone = userPhone;
		this.prior = prior;
		this.userAddress = userAddress;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	private String userAddress;
	public String getUserUuid() {
		return userUuid;
	}
	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	public User() {
		super();
	}
	
	
}
