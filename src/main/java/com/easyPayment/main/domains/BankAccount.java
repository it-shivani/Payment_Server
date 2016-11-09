package com.easyPayment.main.domains;

public class BankAccount {
	private String accountNo;
	private String bankName;
	private String swiftCode;
	private String country;
	
	public BankAccount(){
		
	}

	public BankAccount(String accountNo, String bankName, String swiftCode, String country) {
		super();
		this.accountNo = accountNo;
		this.bankName = bankName;
		this.swiftCode = swiftCode;
		this.country = country;
	}
	
	public void getFromUserBankAccount(UserBankAccount uba){
		this.accountNo = uba.getAccountNumber();
		this.bankName = uba.getBankName();
		this.swiftCode = uba.getSwiftCode();
		this.country = uba.getCountry();
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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

}
