package com.easyPayment.main.services.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easyPayment.main.daos.UserBankAccountDAO;
import com.easyPayment.main.domains.User;
import com.easyPayment.main.domains.UserBankAccount;
import com.easyPayment.main.services.UserBankAccountService;
import com.easyPayment.main.services.UserBankAccountService;
import com.easyPayment.main.services.UserService;
import com.easyPayment.main.utils.MD5Util;

@Service
@Transactional
public class UserBankAccountServiceImpl implements UserBankAccountService  {
	
	@Autowired
	UserBankAccountDAO ubaDao;

	@Override
	public UserBankAccount getUserBankAccountInfo(UserBankAccount uba, User user) {
		UserBankAccount result = ubaDao.getUserBankAccount(uba, user);		
		return result;
	}
	@Override
	public Integer addUserBankAccount(UserBankAccount uba, User user){
		// check user bank account
		UserBankAccount temp = new UserBankAccount();
		temp.setUser(uba.getUser());
//		if (checkUser(temp)) {
//			return 0;
//		}
		temp.setBalance(uba.getBalance());
		temp.setAccountNumber(uba.getAccountNumber());
		temp.setAccountId(uba.getAccountId());
		temp.setBankName(uba.getBankName());
		temp.setSwiftCode(uba.getSwiftCode());
		temp.setCountry(uba.getCountry());
		
		Integer result = ubaDao.insertUserBankAccount(uba, user);
		return result;
	}

	@Override
	public boolean updateUserBankAccount(UserBankAccount uba) {
		UserBankAccount temp = new UserBankAccount();
		
		temp.setBalance(uba.getBalance());
		boolean result = ubaDao.updateUserBankAccount(uba);
		return result;
	}

	@Override
	public Integer deleteUserBankAccount(Integer userBankAccountId){
		UserBankAccount uba = new UserBankAccount();
		uba.setAccountId(userBankAccountId);
		Integer result = ubaDao.deleteUserBankAccount(userBankAccountId);
		return result;
	}
	@Override
	public boolean checkUserBankAccount(UserBankAccount uba, User user){
		boolean bool = true;
		UserBankAccount result = getUserBankAccountInfo(uba, user);
		if (result == null) {
			bool = false;
		} 
		else{
		  bool = true;
		}
		return bool;
	}

	@Override
	public List<UserBankAccount> getUserBankAccountList() {
		List<UserBankAccount> list = ubaDao.getUserBankAccountList();
		List<UserBankAccount> ubas = new ArrayList<UserBankAccount>();
		for (UserBankAccount i : list) {
			UserBankAccount ub = new UserBankAccount();
            ub.setAccountId(i.getAccountId());
            ub.setAccountNumber(i.getAccountNumber());
            ub.setBalance(i.getBalance());
            ub.setBankName(i.getBankName());
            ub.setCountry(i.getCountry());
            ub.setSwiftCode(i.getSwiftCode());
            ub.setUser(i.getUser());
//			friend = userDao.getUser(friend, false);
			ubas.add(ub);
		}
		return ubas;
	}
}
