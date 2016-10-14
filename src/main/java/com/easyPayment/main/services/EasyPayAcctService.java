package com.easyPayment.main.services;

import com.easyPayment.main.domains.EasyPayAccount;

public interface EasyPayAcctService {

	/**
	 * add a new easy-pay account
	 * 
	 * @param epa
	 * @return
	 */
	public boolean addNewAcct(EasyPayAccount epa);

	/**
	 * update an account
	 * 
	 * @param epa
	 * @return
	 */
	public boolean updateAcct(EasyPayAccount epa);

	/**
	 * get an user account by user Id
	 * 
	 * @param userId
	 * @return
	 */
	public EasyPayAccount getAccount(Integer userId);

}
