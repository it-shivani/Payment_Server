package com.easyPayment.main.domains;
 

public class UserBankAccount {
	private int accountId;
	private double balance;
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private long accountNumber;
	private String bankName;
	private int swiftCode;
	private String country;
	
	public UserBankAccount() {
		super();
	}

	public UserBankAccount(long balance, User user, String bankName, int swiftCode, String country) {
		super();
		this.balance = balance;
		this.user = user;
		this.bankName = bankName;
		this.swiftCode = swiftCode;
		this.country = country;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(int swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + swiftCode;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
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
		if (accountId != other.accountId)
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
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
		return "UserBankAccount [accountId=" + accountId + ", balance=" + balance + ", user=" + user
				+ ", accountNumber=" + accountNumber + ", bankName=" + bankName + ", swiftCode=" + swiftCode
				+ ", country=" + country + "]";
	}
	
}
