package com.easyPayment.main.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.easyPayment.main.domains.User;
import com.easyPayment.main.domains.UserBankAccount;

@Repository
public class UserBankAccountDAO extends BaseDao {

	/**
	 * get user Info by user id
	 * 
	 * @param id
	 * @return
	 */
	public UserBankAccount getUserBankAccount(UserBankAccount uba, User user) {
		// query for object
		UserBankAccount result = getSqlSession().selectOne("com.easyPayment.userBankAccount.getUserBankAccount", uba);
		return result;
	}
	/**
	 * update an user bank account
	 * @param userbank account
	 * @return
	 */
	public boolean updateUserBankAccount(UserBankAccount uba) {
		Integer result = getSqlSession().update("com.easyPayment.userBankAccount.updateUserBankAccount", uba);
		if (result != null && result > 0) {
			return true;
		}
		return false;
	}
	/**
	 * insert an user bank account
	 * 
	 * @param user bank account
	 * @return
	 */
	public Integer deleteUserBankAccount(Integer ubaId) {
		Integer result = getSqlSession().delete("com.easyPayment.userBankAccount.deleteUserBankAccount", ubaId);
		return result;
	}
	/**
	 *delete an user bank account
	 * 
	 * @param user bank account
	 * @return
	 */
	public Integer insertUserBankAccount(UserBankAccount uba,User user) {
		Integer result = getSqlSession().insert("com.easyPayment.userBankAccount.insertUserBankAccount", uba);
		return result;
	}
	/**
	 * get user list by condition 
	 * @param condition
	 * @return
	 */
	public List<UserBankAccount> getUserBankAccountList() {
		List<UserBankAccount> ubas = getSqlSession().selectList("com.easyPayment.userBankAccount.getUserBankAccountList");
		return ubas;
	}
}

