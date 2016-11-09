package com.easyPayment.main.services.imp;

import org.springframework.stereotype.Service;

import com.easyPayment.main.domains.BankAccount;
import com.easyPayment.main.services.BankTransferService;

@Service
public class BankTransferServiceImp implements BankTransferService {

	@Override
	public boolean transferAtSameBank(BankAccount from, BankAccount to, double amount) {
		// connect to bank APIs
		
		return true;
	}

	@Override
	public boolean TransferBtnBanks(BankAccount from, BankAccount to, double amount) {
		// connect to bank APIs
		
		return true;
	}

}
