package com.easyPayment.main.daos;

import org.springframework.stereotype.Repository;

import com.easyPayment.main.domains.EasyPayAccount;

@Repository
public class EasyPayAcctDao extends BaseDao {

	/**
	 * add a new account ( with new user registered)
	 * 
	 * @param acct
	 * @return
	 */
	public Integer addNewAcct(EasyPayAccount acct) {
		Integer result = getSqlSession().insert("com.easyPayment.eastPayAcc.addAcct", acct);
		if (result != null && result > 0) {
			return acct.getId();
		}
		return result;
	}

	/**
	 * get an account information
	 * 
	 * @param UserId
	 * @return
	 */
	public EasyPayAccount getAcct(Integer UserId) {
		EasyPayAccount epa = getSqlSession().selectOne("com.easyPayment.eastPayAcc.getAccInfo", UserId);
		return epa;
	}

	/**
	 * update an account
	 * 
	 * @param acct
	 * @return
	 */
	public boolean updateAcct(EasyPayAccount acct) {
		Integer result = getSqlSession().update("com.easyPayment.eastPayAcc.updateAcct", acct);
		if (result != null && result > 0) {
			return true;
		}
		return false;
	}

}
