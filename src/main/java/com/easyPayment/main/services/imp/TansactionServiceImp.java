package com.easyPayment.main.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyPayment.main.daos.TransactionDao;
import com.easyPayment.main.domains.BankAccount;
import com.easyPayment.main.domains.EasyPayAccount;
import com.easyPayment.main.domains.Transaction;
import com.easyPayment.main.domains.UserBankAccount;
import com.easyPayment.main.services.BankTransferService;
import com.easyPayment.main.services.EasyPayAcctService;
import com.easyPayment.main.services.TransferService;
import com.easyPayment.main.services.UserBankAccountService;
import com.easyPayment.main.utils.Status;
import com.easyPayment.main.utils.SystemBankAccount;

@Service
@Transactional
public class TansactionServiceImp implements TransferService {

	@Autowired
	TransactionDao transactionDao;

	@Autowired
	EasyPayAcctService easyPayAcctService;
	
	@Autowired
	BankTransferService bankTransferService;
	
	@Autowired
	UserBankAccountService userBankAccountService;

	@Override
	public int makeTransferToUser(Transaction trans) {
		// 1 check use 1 have account and balance is enough to pay
		EasyPayAccount epa1 = easyPayAcctService.getAccount(trans.getUserId());
		if (epa1 == null) {
			return Status.TRANSFER_USER_DOESNOT_EXISTED;
		} else if (epa1.getBalance() < trans.getAmount()) {
			return Status.TRANSFER_BALANCE_NOT_ENOUGH;
		}
		// 2 check use-2 is existed
		EasyPayAccount epa2 = easyPayAcctService.getAccount(trans.getToAcct());
		if (epa2 == null) {
			return Status.TRANSFER_USER_DOESNOT_EXISTED;
		}
		// 3 make transfer
		double ub1 = epa1.getBalance() - trans.getAmount();
		epa1.setBalance(ub1);
		double ub2 = epa2.getBalance() + trans.getAmount();
		epa2.setBalance(ub2);
		if (!easyPayAcctService.updateAcct(epa1)) {
			return Status.TRANSFER_FAILED;
		}
		if (!easyPayAcctService.updateAcct(epa2)) {
			return Status.TRANSFER_FAILED;
		}
		//add into transfer info
		transactionDao.addNewTransaction(trans);
		return Status.TRANSFER_SUCCESS;
	}

	@Override
	public List<Transaction> transferList(Transaction trans) {
		List<Transaction> resultList = transactionDao.getTransList(trans);
		return resultList;
	}

	@Override
	public int makeTransferToBank(UserBankAccount userBank,double amount) {
		//make sure balance is SUFFICIENT
		EasyPayAccount epa = easyPayAcctService.getAccount(userBank.getUserId());
		if(epa.getBalance() < amount){
			return Status.INSUFFICIENT_BALANCE;
		}
		//make transfer
		BankAccount sysBank = SystemBankAccount.getSystemBankAccount(userBank.getBankName());
		BankAccount userBa= new BankAccount();
		userBa.getFromUserBankAccount(userBank);
		boolean result = bankTransferService.transferAtSameBank(sysBank,userBa, amount);
		//transfer done, make modify on account
		if(result){
			epa.setBalance(epa.getBalance()-amount);
			easyPayAcctService.updateAcct(epa);
		}else{
			return Status.TRANSFER_FAILED;
		}
		return Status.TRANSFER_SUCCESS;
	}
	
	@Override
	public int makeTransferFromBank(UserBankAccount userBank,double amount) {
		EasyPayAccount epa = easyPayAcctService.getAccount(userBank.getUserId());
		//make transfer
		BankAccount sysBank = SystemBankAccount.getSystemBankAccount(userBank.getBankName());
		BankAccount userBa= new BankAccount();
		userBa.getFromUserBankAccount(userBank);
		boolean result = bankTransferService.transferAtSameBank(userBa,sysBank, amount);
		//transfer done, make modify on account
		if(result){
			epa.setBalance(epa.getBalance()+amount);
			easyPayAcctService.updateAcct(epa);
		}else{
			return Status.TRANSFER_FAILED;
		}
		return Status.TRANSFER_SUCCESS;
	}

}
