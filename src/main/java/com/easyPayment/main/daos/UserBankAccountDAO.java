package com.easyPayment.main.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.easyPayment.main.domains.UserBankAccount;

@Repository
public class UserBankAccountDAO extends BaseDao {

	/**
	 * get User Bank Accounts
	 */
	public List<UserBankAccount> getUserBankAccounts(UserBankAccount uba) {
		// query for object
		List<UserBankAccount> result = getSqlSession().selectList("com.easyPayment.userBankAccount.getUserBankAccount",
				uba);
		return result;
	}

	/**
	 * update an user bank account
	 */
	public boolean updateUserBankAccount(UserBankAccount uba) {
		Integer result = getSqlSession().update("com.easyPayment.userBankAccount.updateUserBankAccount", uba);
		if (result != null && result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * delete User Bank Account
	 */
	public boolean deleteUserBankAccount(Integer ubaId) {
		Integer result = getSqlSession().delete("com.easyPayment.userBankAccount.deleteUserBankAccount", ubaId);
		if(result == null || result <= 0){
			return false;
		}
		return true;
	}

	/**
	 * insert User Bank Account
	 */
	public Integer insertUserBankAccount(UserBankAccount uba) {
		Integer result = getSqlSession().insert("com.easyPayment.userBankAccount.insertUserBankAccount", uba);
		if (result != null && result > 0) {
			return uba.getId();
		}
		return result;
	}

	/**
	 * get User Bank Account List
	 * 
	 * DO NOT USE THIS FUNCTION AS MAY CAUSE EXCEPTION
	 */
	public List<UserBankAccount> getUserBankAccountList() {
		List<UserBankAccount> ubas = getSqlSession()
				.selectList("com.easyPayment.userBankAccount.getUserBankAccountList");
		return ubas;
	}
}
