package com.easyPayment.main.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyPayment.main.daos.EasyPayAcctDao;
import com.easyPayment.main.domains.EasyPayAccount;
import com.easyPayment.main.services.EasyPayAcctService;

@Service
public class EasyPayAcctServiceImp implements EasyPayAcctService {

	@Autowired
	EasyPayAcctDao easyPayAcctDao;

	@Override
	public boolean addNewAcct(EasyPayAccount epa) {
		Integer result = easyPayAcctDao.addNewAcct(epa);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAcct(EasyPayAccount epa) {
		boolean result = easyPayAcctDao.updateAcct(epa);
		return result;
	}

	@Override
	public EasyPayAccount getAccount(Integer userId) {
		EasyPayAccount result = easyPayAcctDao.getAcct(userId);
		return result;
	}

}
