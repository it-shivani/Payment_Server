package com.easyPayment.main.services;

import java.util.List;

import com.easyPayment.main.domains.Transaction;

public interface TransferService {

	/**
	 * transfer money
	 */
	public int makeTransfer(Transaction trans);

	/**
	 * get transaction list
	 */
	public List<Transaction> transferList(Transaction trans);

}
