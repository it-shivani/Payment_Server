package com.easyPayment.main.services;

import java.util.List;

import com.easyPayment.main.domains.UserBankAccount;

public interface UserBankAccountService {
	/**
	 * get User Bank Account Info
	 */
	public UserBankAccount getUserBankAccountInfo(UserBankAccount uba);

	/**
	 * check user bank account
	 */
	public boolean checkUserBankAccount(UserBankAccount uba);

	/**
	 * add a new user bank account
	 */
	public Integer addUserBankAccount(UserBankAccount uba);

	/**
	 * update User Bank Account
	 */
	public boolean updateUserBankAccount(UserBankAccount uba);

	/**
	 * delete user bank account through bank account id
	 */
	public boolean deleteUserBankAccount(Integer userBankAccountId);

	/**
	 * get user bank account list
	 */
	public List<UserBankAccount> getUserBankAccountList(UserBankAccount uba);

}
