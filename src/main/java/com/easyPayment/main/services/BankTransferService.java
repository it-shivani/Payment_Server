package com.easyPayment.main.services;

import com.easyPayment.main.domains.BankAccount;

/**
 * for bank transfer 
 * @author zhao_zl_
 *
 */
public interface BankTransferService {

	/**
	 * transfer money  at same bank
	 * @return
	 */
	public boolean transferAtSameBank(BankAccount from, BankAccount to, double amount);

	/**
	 * transfer money between different banks
	 * @return
	 */
	public boolean TransferBtnBanks(BankAccount from, BankAccount to, double amount);

}
