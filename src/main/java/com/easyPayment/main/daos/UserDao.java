package com.easyPayment.main.daos;

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
	public User GetUser(User user) {
		// query for object
		User result = getSqlSession().selectOne("com.easyPayment.user.getUser", user);
		return result;
	}

}
