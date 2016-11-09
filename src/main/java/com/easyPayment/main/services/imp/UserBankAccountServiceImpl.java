package com.easyPayment.main.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyPayment.main.daos.UserBankAccountDAO;
import com.easyPayment.main.domains.UserBankAccount;
import com.easyPayment.main.services.UserBankAccountService;

@Service
@Transactional
public class UserBankAccountServiceImpl implements UserBankAccountService {

	@Autowired
	UserBankAccountDAO ubaDao;

	@Override
	public UserBankAccount getUserBankAccountInfo(UserBankAccount uba) {
		List<UserBankAccount> result = ubaDao.getUserBankAccounts(uba);
		if (result.get(0) != null) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public Integer addUserBankAccount(UserBankAccount uba) {
		Integer result = ubaDao.insertUserBankAccount(uba);
		return result;
	}

	@Override
	public boolean updateUserBankAccount(UserBankAccount uba) {
		boolean result = ubaDao.updateUserBankAccount(uba);
		return result;
	}

	@Override
	public boolean deleteUserBankAccount(Integer userBankAccountId) {
		UserBankAccount uba = new UserBankAccount();
		uba.setId(userBankAccountId);
		boolean result = ubaDao.deleteUserBankAccount(userBankAccountId);
		return result;
	}

	@Override
	public boolean checkUserBankAccount(UserBankAccount uba) {
		boolean bool = true;
		UserBankAccount result = getUserBankAccountInfo(uba);
		if (result == null) {
			bool = false;
		} else {
			bool = true;
		}
		return bool;
	}

	@Override
	public List<UserBankAccount> getUserBankAccountList(UserBankAccount uba) {
		List<UserBankAccount> list = ubaDao.getUserBankAccounts(uba);	
		return list;
	}
}
