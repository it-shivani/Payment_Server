package com.easyPayment.main.services;

import java.util.List;
import com.easyPayment.main.domains.*;

public interface UserBankAccountService {
	/**
	 * find user through some user's information
	 * 
	 * @param user
	 * @param needPassword
	 * @return
	 */
	public UserBankAccount getUserBankAccountInfo(UserBankAccount uba, User user);
	
	/**
	 * check user
	 * @param user
	 * @return
	 */
	public boolean checkUserBankAccount(UserBankAccount uba, User user);

	/**
	 * add a new user bank account
	 * 
	 * @param user
	 * @return
	 */
	public Integer addUserBankAccount(UserBankAccount uba, User user);

	/**
	 * update a user
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUserBankAccount(UserBankAccount uba);

	/**
	 * delete user through user id
	 * 
	 * @param userId
	 * @return
	 */
	public Integer deleteUserBankAccount(Integer userBankAccountId);

	/**
	 * get user bank account list
	 * 
	 * @param userID
	 * @return
	 */
	public List<UserBankAccount> getUserBankAccountList();

}
