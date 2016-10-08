package com.easyPayment.main.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.easyPayment.main.domains.User;

@Repository
public class UserDao extends BaseDao {

	/**
	 * get user Info by user id
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(User user) {
		// query for object
		User result = getSqlSession().selectOne("com.easyPayment.user.getUser", user);
		return result;
	}

	/**
	 * update an user
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user) {
		Integer result = getSqlSession().update("com.easyPayment.user.updateUser", user);
		if (result != null && result > 0) {
			return true;
		}

		return false;
	}

	/**
	 * insert an user
	 * 
	 * @param user
	 * @return
	 */
	public Integer insertUser(User user) {
		Integer result = getSqlSession().insert("com.easyPayment.user.insertUser", user);
		return result;
	}

	/**
	 * get user list by condition
	 * 
	 * @param condition
	 * @return
	 */
	public List<User> getUserList(User condition) {
		return null;
	}

}
