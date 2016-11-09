package com.easyPayment.main.domains;

public class UserBankAccount {
	private Integer id;
	private Integer userId;
	private User user;
	private String accountNumber;
	private String bankName;
	private String swiftCode;
	private String country;

	public UserBankAccount() {
		super();
	}

	public UserBankAccount(long balance, User user, String bankName, String swiftCode, String country) {
		super();
		this.user = user;
		this.bankName = bankName;
		this.swiftCode = swiftCode;
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBankAccount other = (UserBankAccount) obj;
		if (userId != other.userId)
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (swiftCode != other.swiftCode)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserBankAccount [accountId=" + userId + ", user=" + user + ", accountNumber=" + accountNumber
				+ ", bankName=" + bankName + ", swiftCode=" + swiftCode + ", country=" + country + "]";
	}

}
