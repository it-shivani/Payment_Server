package com.easyPayment.main.services;

import com.easyPayment.main.domains.BankAccount;

public interface SystemBankAccountService {

	public void transIntoAccount(BankAccount ba);

	public void clearing();
}
