package com.easyPayment.main.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyPayment.main.daos.TransactionDao;
import com.easyPayment.main.domains.EasyPayAccount;
import com.easyPayment.main.domains.Transaction;
import com.easyPayment.main.services.EasyPayAcctService;
import com.easyPayment.main.services.TransferService;
import com.easyPayment.main.utils.Status;

@Service
@Transactional
public class TansactionServiceImp implements TransferService {

	@Autowired
	TransactionDao transactionDao;

	@Autowired
	EasyPayAcctService easyPayAcctService;

	@Override
	public int makeTransfer(Transaction trans) {
		// 1 check use 1 have account and balance is enough to pay
		EasyPayAccount epa1 = easyPayAcctService.getAccount(trans.getUserId());
		if (epa1 == null) {
			return Status.TRANSFER_USER_DOESNOT_EXISTED;
		} else if (epa1.getBalance() < trans.getAmount()) {
			return Status.TRANSFER_BALANCE_NOT_ENOUGH;
		}
		// 2 check use 2 is existed
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

}
