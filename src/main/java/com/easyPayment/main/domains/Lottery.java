package com.easyPayment.main.domains;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Lottery {

	private Integer id;
	private Integer createrId;
	private double betAmount;
	private double totalAmount;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endDate;
	private Integer winnerId;
	private String status;
	private List<User> attenders;

	/**
	 * check 
	 * @return
	 */
	public boolean checkLottery() {
		boolean result = false;
		if (this.createrId == null || this.createrId.equals("")) {
			return result;
		}
		if (this.betAmount == 0.00) {
			return result;
		}
		if (this.endDate == null) {
			return result;
		}
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}

	public double getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(Integer winnerId) {
		this.winnerId = winnerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<User> getAttenders() {
		return attenders;
	}

	public void setAttenders(List<User> attenders) {
		this.attenders = attenders;
	}

}
