package com.easyPayment.main.domains;

import java.util.Date;

public class Transaction {
	private Integer id;
	private double balance;
	private Integer userId; // user id who send the money 
	private String fromAcct; // can be empty
	private Date postTime;
	private String description;
	private String type;
	private String status;
	private double amount;
	private Integer toAcct; // User id which who get the money
	
	
	public Integer getToAcct() {
		return toAcct;
	}
	public void setToAcct(Integer toAcct) {
		this.toAcct = toAcct;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFromAcct() {
		return fromAcct;
	}
	public void setFromAcct(String fromAcct) {
		this.fromAcct = fromAcct;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
