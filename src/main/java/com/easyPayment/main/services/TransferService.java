package com.easyPayment.main.services;

import java.util.List;

import com.easyPayment.main.domains.Transaction;
import com.easyPayment.main.domains.UserBankAccount;

public interface TransferService {

	/**
	 * transfer money to user
	 */
	public int makeTransferToUser(Transaction trans);
	
	/**
	 * transfer money to bank
	 * @return
	 */
	public int makeTransferToBank(UserBankAccount to,double amount);
	
	/**
	 * transfer money from bank
	 * @return
	 */
	public int makeTransferFromBank(UserBankAccount userBank,double amount);

	/**
	 * get transaction list
	 */
	public List<Transaction> transferList(Transaction trans);

}
