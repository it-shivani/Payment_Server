package com.easyPayment.main.utils;

import com.easyPayment.main.domains.BankAccount;

/**
 * just a template for system bank account
 * 
 * @author zhao_zl_
 *
 */
public class SystemBankAccount {

	public static BankAccount BankOfAmerica = new BankAccount("3344232", "BankOfAmerica", "434NA", "USA");

	public static BankAccount USBank = new BankAccount("2344232", "USBank", "354NA", "USA");

	public static BankAccount CITIBank = new BankAccount("8341432", "CITIBank", "874NA", "USA");
	
	public static BankAccount ChaseBank = new BankAccount("1001432", "ChaseBank", "109NA", "USA");
	
	public static BankAccount WellsFargo = new BankAccount("7701491", "WellsFargo", "449NA", "USA");

	public static BankAccount getSystemBankAccount(String bankName) {
		BankAccount bank = null;
		switch (bankName) {
		case "citibank":
			bank = CITIBank;
			break;
		case "USBank":
			bank = USBank;
			break;
		case "BankOfAmerica":
			bank = BankOfAmerica;
			break;
		case "ChaseBank":
			bank = ChaseBank;
			break;
		case "WellsFargo":
			bank = WellsFargo;
			break;
		}
		return bank;
	}
	
	public static BankAccount getSystemBankAccountInCapital(String bankName) {
		BankAccount bank = null;
		switch (bankName) {
		case "CITIBANK":
			bank = CITIBank;
			break;
		case "USBANK":
			bank = USBank;
			break;
		case "BANKOFAMERICA":
			bank = BankOfAmerica;
			break;
		case "CHASEBANK":
			bank = ChaseBank;
			break;
		case "WELLSFARGO":
			bank = WellsFargo;
			break;
		}
		return bank;
	}
}
